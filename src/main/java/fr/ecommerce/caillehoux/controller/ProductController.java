package fr.ecommerce.caillehoux.controller;

import fr.ecommerce.caillehoux.exception.ExistingProductExecption;
import fr.ecommerce.caillehoux.exception.ResourceNotFoundException;
import fr.ecommerce.caillehoux.exception.StockException;
import fr.ecommerce.caillehoux.model.Product;
import fr.ecommerce.caillehoux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.SocketException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = {""})
    public List<Product> getProducts() {
        return (List<Product>) productService.getAllProducts();
    }

    @GetMapping(value = {"{productId}"})
    public ResponseEntity<Product> getProductById(@PathVariable("productId") long id) {
        try {
             return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(value = {"/addProduct"})
    public ResponseEntity<List<Product>> addProduct(@RequestBody Product newProduct) {
        if (productService.getAllProducts().stream().anyMatch(product -> product.getName().equals(newProduct.getName()))) {
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.CONFLICT);
        } else {
            productService.save(newProduct);
            return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
        }
    }

    @PostMapping(value = {"/removeProduct/{productId}/{quantity}"})
    public ResponseEntity<List<Product>> removeProduct(@RequestParam("productId") long productId,@RequestParam("quantity") int quantity) {
        try {
            productService.removeProduct(productId,quantity);
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }catch (StockException e) {
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.CONFLICT);
        }
    }
}

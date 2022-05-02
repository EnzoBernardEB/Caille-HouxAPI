package fr.ecommerce.caillehoux.controller;

import fr.ecommerce.caillehoux.exception.ResourceNotFoundException;
import fr.ecommerce.caillehoux.exception.StockException;
import fr.ecommerce.caillehoux.model.Client;
import fr.ecommerce.caillehoux.model.Product;
import fr.ecommerce.caillehoux.service.ClientService;
import fr.ecommerce.caillehoux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

    @Autowired
    ClientService clientService;


    @PostMapping(value = {"/login"})
    public ResponseEntity<Client> getProductById(@RequestBody Client client) {
        if(clientService.authenticated(client).isPresent()) {
            return ResponseEntity.ok(clientService.authenticated(client).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

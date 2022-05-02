package fr.ecommerce.caillehoux.service;



import fr.ecommerce.caillehoux.exception.ResourceNotFoundException;
import fr.ecommerce.caillehoux.exception.StockException;
import fr.ecommerce.caillehoux.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product save(Product product);
    public boolean isProductAvailable(Product product, int quantity);
    public void removeProduct(long productId, int quantity) throws StockException, ResourceNotFoundException;
}

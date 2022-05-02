package fr.ecommerce.caillehoux.service;

import fr.ecommerce.caillehoux.exception.StockException;
import fr.ecommerce.caillehoux.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public Order create(Order order);
    public void update(Order order) throws StockException;
}

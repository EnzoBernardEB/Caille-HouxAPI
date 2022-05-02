package fr.ecommerce.caillehoux.repository;

import fr.ecommerce.caillehoux.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}

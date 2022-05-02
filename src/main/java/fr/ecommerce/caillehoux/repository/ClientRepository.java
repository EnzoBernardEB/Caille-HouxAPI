package fr.ecommerce.caillehoux.repository;

import fr.ecommerce.caillehoux.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
   Optional<Client> findByUsernameAndPassword(String name, String password);
}

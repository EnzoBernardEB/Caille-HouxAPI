package fr.ecommerce.caillehoux.controller;

import fr.ecommerce.caillehoux.model.Client;
import fr.ecommerce.caillehoux.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/")
    public List<Client> index() {
        return clientRepository.findAll();
    }
}

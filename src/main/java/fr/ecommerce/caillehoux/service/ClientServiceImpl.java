package fr.ecommerce.caillehoux.service;

import fr.ecommerce.caillehoux.exception.ResourceNotFoundException;
import fr.ecommerce.caillehoux.model.Client;
import fr.ecommerce.caillehoux.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service("clients")
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) {
        Optional<Client> result = clientRepository.findById(clientId);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Client save(Client client) {
       Client result = clientRepository.save(client);
        return result;
    }

    @Override
    public Optional<Client> authenticated(Client client) {
        return clientRepository.findByUsernameAndPassword(client.getUsername(),client.getPassword());
    }
}

package ru.chaikhana.service.client;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.chaikhana.model.Client;
import ru.chaikhana.model.Product;
import ru.chaikhana.repository.ClientRepository;

@Service
@Data
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;


    @Override
    public Client getClientById(String id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    //Удаление и ниже добавление продукт Клиенту
    @Override
    public void deleteProductInClient(Product product, String clientId) {
        Client client = getClientById(clientId);
        if(client!=null){
            client.getProducts().remove(product);
            updateClient(client);
        }
    }

    @Override
    public void addProductInClient(Product product, String clientId) {
        Client client = getClientById(clientId);
        if(client!=null){
            client.getProducts().add(product);
            updateClient(client);
        }
    }
}

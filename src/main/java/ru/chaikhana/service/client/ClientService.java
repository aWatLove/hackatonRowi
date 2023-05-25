package ru.chaikhana.service.client;

import ru.chaikhana.model.Client;
import ru.chaikhana.model.Product;

public interface ClientService {
    Client getClientById(String id);
    Client addClient(Client client);
    void deleteClient(Client client);
    Client updateClient(Client client);
    void deleteProductInClient(Product product, String clientId);
    void addProductInClient(Product product, String clientId);
}

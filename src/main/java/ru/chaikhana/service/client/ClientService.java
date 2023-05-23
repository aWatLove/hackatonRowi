package ru.chaikhana.service.client;

import ru.chaikhana.model.Client;

public interface ClientService {
    Client getClientById(String id);
    Client addClient(Client client);
    void deleteClient(Client client);
    Client updateClient(Client client);
}

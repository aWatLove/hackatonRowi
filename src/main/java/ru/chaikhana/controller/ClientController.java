package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.chaikhana.model.Client;
import ru.chaikhana.model.Product;
import ru.chaikhana.model.User;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.service.client.ClientService;
import ru.chaikhana.service.clientchat.ClientChatService;
import ru.chaikhana.service.user.UserService;
@AllArgsConstructor
@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;
    private final ClientChatService clientChatService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable String id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PutMapping("/")
    public ResponseEntity<?> updateClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteClient(@RequestBody Client client) {
        clientService.deleteClient(client);
        return ResponseEntity.ok("deleted");
    }

    // Добавить продукт из списка Клиента
    @GetMapping("/product/add")
    public ResponseEntity<?> addProduct(Product product, String clientId) {
        clientService.addProductInClient(product, clientId);
        clientChatService.addProductInClientChat(product, clientId);
        return ResponseEntity.ok("added product");
    }

    // Удалить продукт из списка Клиента
    @GetMapping("/product/delete")
    public ResponseEntity<?> deleteProduct(Product product, String clientId) {
        clientService.deleteProductInClient(product, clientId);
        clientChatService.deleteProductInClientChat(product, clientId);
        return ResponseEntity.ok("deleted product");
    }
}

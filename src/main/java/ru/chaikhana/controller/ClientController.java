package ru.chaikhana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.chaikhana.model.Client;
import ru.chaikhana.model.User;
import ru.chaikhana.service.client.ClientService;
import ru.chaikhana.service.user.UserService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientService clientService;

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

    // mock
    @GetMapping("/product/add")
    public ResponseEntity<?> addProduct() {
        return ResponseEntity.ok("added product");
    }

    // mock
    @GetMapping("/product/delete")
    public ResponseEntity<?> deleteProduct() {
        return ResponseEntity.ok("deleted product");
    }


}

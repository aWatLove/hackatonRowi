package ru.chaikhana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chaikhana.model.Client;
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

    @GetMapping("/chat/resolve")
    public ResponseEntity<?> resolvedQuest() {
        return ResponseEntity.ok("resolved");
    }

    @GetMapping("/chat/open")
    public ResponseEntity<?> openChat() {
        return ResponseEntity.ok("open");
    }

    @GetMapping("/chat/close")
    public ResponseEntity<?> closeChat() {
        return ResponseEntity.ok("close");
    }

    @GetMapping("/product/add")
    public ResponseEntity<?> addProduct() {
        return ResponseEntity.ok("added product");
    }

//    @GetMapping
//    public ResponseEntity<L>
}

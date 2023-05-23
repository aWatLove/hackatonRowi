package ru.chaikhana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chaikhana.model.Client;

@RestController
@RequestMapping("/api/client")
public class ClientController {

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

package ru.chaikhana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/manager")
public class ManagerController {


    @GetMapping("/getAllChat")
    public ResponseEntity<?> getAllOpenChat() {
        return ResponseEntity.ok("чаты лол");
    }

    @GetMapping("/openChat")
    public ResponseEntity<?> openChat(String id) {
        return ResponseEntity.ok("chat " + id);
    }

    @GetMapping("/chat/change")
    public ResponseEntity<?> changeCategory() {
        return ResponseEntity.ok("changed");
    }
}

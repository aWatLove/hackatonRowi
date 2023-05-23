package ru.chaikhana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/auth/register")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok("register");
    }

    @GetMapping("/auth/authenticate")
    public ResponseEntity<?> authenticate() {
        return ResponseEntity.ok("auth");
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok("all users");
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUser() {
        return ResponseEntity.ok("update user");
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUser(String id) {
        return ResponseEntity.ok("delete user "+ id);
    }


}

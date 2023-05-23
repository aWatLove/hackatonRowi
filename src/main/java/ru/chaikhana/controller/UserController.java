package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chaikhana.model.User;
import ru.chaikhana.service.user.UserServiceImpl;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userService;
    @GetMapping("/auth/register")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok("register");
    }

    @GetMapping("/auth/authenticate")
    public ResponseEntity<String> authenticate(String login, String password) {
        User user = userService.getUserByLogin(login, password);
        return ResponseEntity.ok(user.getRole() + " " + user.getIdForeign());
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

package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chaikhana.model.User;
import ru.chaikhana.service.user.UserServiceImpl;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/auth/{login}")
    public ResponseEntity<String> authenticate(@PathVariable("login") String login) {
        User user = userService.getUserByLogin(login).orElse(null);
        return ResponseEntity.ok(user.getRole() + " " + user.getIdForeign());
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PutMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUser(String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("deleted");
    }


}

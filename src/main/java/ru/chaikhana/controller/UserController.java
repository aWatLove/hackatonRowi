package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chaikhana.model.LoginRequest;
import ru.chaikhana.model.User;
import ru.chaikhana.service.user.UserService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    /*Аутентификация пользователя, получаем роль и
     Id пользователя, передавая Логин и пароль*/
    @GetMapping("/auth/{login}")
    public ResponseEntity<?> authenticate(@PathVariable("login") String login) {
        User user = userService.getUserByLogin(login).orElse(null);
        if(user != null) {
            return ResponseEntity.ok(new LoginRequest(user.getRole(), user.getIdForeign()));
        } else return ResponseEntity.status(404).body("not found");
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

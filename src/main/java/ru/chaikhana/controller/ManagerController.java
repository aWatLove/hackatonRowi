package ru.chaikhana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chaikhana.service.manager.ManagerService;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getManager(@PathVariable String id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    @GetMapping("/chat/getAll")
    public ResponseEntity<?> getAllOpenChat() {
        return ResponseEntity.ok("чаты лол");
    }

    @GetMapping("/chat/open")
    public ResponseEntity<?> openChat(String id) {
        return ResponseEntity.ok("chat " + id);
    }

    @GetMapping("/chat/change")
    public ResponseEntity<?> changeCategory() {
        return ResponseEntity.ok("changed");
    }
}

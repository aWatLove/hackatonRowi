package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.service.clientchat.ClientChatServiceImpl;
import ru.chaikhana.service.manager.ManagerService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    private final ManagerService managerService;
    private final ClientChatServiceImpl clientChatService;

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

    @GetMapping("/api/manager/chat/getByTypeAndStatus")
    public List<ClientChat> getAllClientChatByTypeAndStatus(String chatType, String chatStatus){
        return clientChatService.getAllClientChatByTypeChatAndStatus(chatType, chatStatus);
    }
}

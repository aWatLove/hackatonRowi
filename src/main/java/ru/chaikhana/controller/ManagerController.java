package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.service.clientchat.ClientChatService;
import ru.chaikhana.service.manager.ManagerService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/manager")
public class ManagerController {
    private final ManagerService managerService;
    private final ClientChatService clientChatService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getManager(@PathVariable String id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    /*Поиск всех чатов для менеджера по его категории,
     соответсвующие запрашиваему статусу */
    @GetMapping("/chat/getByChatCategoryAndStatus")
    public List<ClientChat> getAllClientChatByChatCategoryAndStatus(String chatCategory, String chatStatus){
        return clientChatService.getAllClientChatByChatCategoryAndStatus(chatCategory, chatStatus);
    }
}

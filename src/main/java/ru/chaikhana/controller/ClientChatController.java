package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.chaikhana.model.Message;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.service.clientchat.ClientChatServiceImpl;
import ru.chaikhana.service.message.MessageServiceImpl;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClientChatController {
    private final ClientChatServiceImpl clientChatService;
    private final MessageServiceImpl messageService;

//===============Теперь чуть поумнее========================== Смена категории
    @PostMapping("/api/chat/message/send")
    public ResponseEntity<Message> sendMessageInChatArray(@RequestBody Message message, String clientId){
        return ResponseEntity.ok(messageService.addMessage(message, clientId));
    }
    @GetMapping("/api/chat/message/get")
    public ResponseEntity<List<Message>> getAllMessageFromClientChat(String clientId){
        return ResponseEntity.ok(messageService.getAllMessageFromClientChatByClientId(clientId));
    }
    @GetMapping("/api/chat/client/getClientChatByClientId")
    public ResponseEntity<ClientChat> getClientChatByClientId(String clientId){
        return ResponseEntity.ok(clientChatService.getClientChatByClientId(clientId));
    }
//===========================================================

}

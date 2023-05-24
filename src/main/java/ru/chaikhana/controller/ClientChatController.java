package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
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


//================================================================
    @GetMapping("/api/chat/message/getAllMessageLC")
    public List<Message> getAllMessage(){
        return messageService.getAllMessage();
    }


//===============Теперь чуть поумнее==========================
    @PostMapping("/api/chat/message/send")
    public Message sendMessageInChatArray(@RequestBody Message message, String clientId){
        return messageService.addMessage(message, clientId);
    }
    @GetMapping("/api/chat/message/get")
    public List<Message> getAllMessageFromClientChat(String clientId){
        return messageService.getAllMessageFromClientChatByClientId(clientId);
    }
    @GetMapping("/api/chat/client/getClientChatByClientId")
    public ClientChat getClientChatByClientId(String clientId){
        return clientChatService.getClientChatByClientId(clientId);
    }
//===========================================================

}

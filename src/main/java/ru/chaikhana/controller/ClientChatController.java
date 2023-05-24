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
    @GetMapping("/api/manager/chat/getByTypeAndStatus")
    public List<ClientChat> getAllClientChatByTypeAndStatus(String chatType, String chatStatus){
        return clientChatService.getAllClientChatByTypeChatAndStatus(chatType, chatStatus);
    }

    @GetMapping("/api/client/chat/getClientChatByClientId")
    public ClientChat getClientChatByClientId(String id){
        return clientChatService.getClientChatById(id);
    }

    @GetMapping("/api/chat/message/getAllMessageLC")
    public List<Message> getAllMessage(){
        return messageService.getAllMessage();
    }

    @PostMapping("/api/chat/message/send")
    public Message sendMessageInCollection(@RequestBody Message message){
        return messageService.addMessage(message);
    }
//===============Теперь чуть поумнее==========================
    @GetMapping("/api/chat/message/get")
    public List<Message> getAllMessageFromClientChat(String clientId){
        return messageService.getAllMessageFromClientChatByClientId(clientId);
    }

//===========================================================

}

package ru.chaikhana.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.chaikhana.model.Message;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.service.clientchat.ClientChatService;
import ru.chaikhana.service.message.MessageService;

import java.util.List;

@AllArgsConstructor
@RestController
//Метод менеджер выбрал чат ну типа айди, изменение статуса и т.д.
public class ClientChatController {
    private final ClientChatService clientChatService;
    private final MessageService messageService;

    /*Отправление сообщения в чат со стороны клиента и менеджера*/
    @PostMapping("/api/chat/message/send")
    public ResponseEntity<Message> sendMessageInChatArray(@RequestBody Message message, String clientId){
        return ResponseEntity.ok(messageService.addMessage(message, clientId));
    }
    /*Получение массива сообщений из чата клиента для отоброжения в диалоговом окне*/
    @GetMapping("/api/chat/message/get")
    public ResponseEntity<List<Message>> getAllMessageFromClientChat(String clientId){
        return ResponseEntity.ok(messageService.getAllMessageFromClientChatByClientId(clientId));
    }
    /*Получение чата для отоброжения в профиле клиента*/
    @GetMapping("/api/chat/client/getClientChatByClientId")
    public ResponseEntity<ClientChat> getClientChatByClientId(String clientId){
        return ResponseEntity.ok(clientChatService.getClientChatByClientId(clientId));
    }
    /*Изменение категории чата для перенаправления от одного менеджера к другому*/
    @PostMapping("/api/chat/setChatCategory")
    public ResponseEntity<String> changeChatCategory(String chatCategory, String clientId){
        clientChatService.changeClientChatCategory(chatCategory, clientId);
        return ResponseEntity.ok("Category has been changed on "+ chatCategory);
    }
    /*Изменение статуса чата для определения правильного отображения*/
    @PostMapping("/api/chat/setChatStatus")
    public ResponseEntity<String> changeChatStatus(String chatStatus, String clientId){
        clientChatService.changeClientChatStatus(chatStatus, clientId);
        return ResponseEntity.ok("Status has been changed on "+ chatStatus);
    }
    /*Изменение Id менеджера для отслеживания занятости чата менеджером*/
    @PostMapping("/api/chat/setManagerId")
    public ResponseEntity<String> changeManagerId(String managerId, String clientId){
        clientChatService.changeManagerIdInClientChat(managerId, clientId);
        return ResponseEntity.ok("ManagerId has been changed on "+ managerId);
    }
}

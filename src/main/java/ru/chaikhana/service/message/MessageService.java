package ru.chaikhana.service.message;

import ru.chaikhana.model.Message;

import java.util.List;

public interface MessageService {
    //Тоже временное решение так-то
    List<Message> getAllMessage();
    List<Message> getAllMessageByClientId(String id);
    Message addMessage(Message message, String clientId);
    void deleteMessage(Message message);
    Message updateMessage(Message message);
    List<Message> getAllMessageFromClientChatByClientId(String clientId);
}

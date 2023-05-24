package ru.chaikhana.service.message;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.chaikhana.model.Manager;
import ru.chaikhana.model.Message;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.repository.ClientChatRepository;
import ru.chaikhana.repository.MessageRepository;
import ru.chaikhana.service.clientchat.ClientChatServiceImpl;
import ru.chaikhana.service.manager.ManagerService;

import java.util.List;

@Service
@Data
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ClientChatServiceImpl clientChatService;

    @Override
    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getAllMessageByClientId(String id) {
        ClientChat clientChat = clientChatService.getClientChatById(id);
        return clientChat.getMessages();
    }

    @Override
    public void deleteMessage(Message message) {
        messageRepository.delete(message);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }



    @Override
    public List<Message> getAllMessageFromClientChatByClientId(String clientId) {
        return clientChatService.getClientChatByClientId(clientId).getMessages();
    }
    @Override
    public Message addMessage(Message message, String clientId) {
        ClientChat clientChat = clientChatService.getClientChatByClientId(clientId);
        if(clientChat.getChatStatus().equals("isClosed")){
            clientChat.setChatCategory("ordinary");
            clientChat.setChatStatus("isOpenNotBusy");
        }
        clientChat.getMessages().add(message);
        clientChatService.updateClientChat(clientChat);
        return message;
    }
}

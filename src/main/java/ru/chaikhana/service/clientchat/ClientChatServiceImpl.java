package ru.chaikhana.service.clientchat;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.repository.ClientChatRepository;

import java.util.List;

@Service
@Data
public class ClientChatServiceImpl implements ClientChatService {
    private final ClientChatRepository clientChatRepository;

    @Override
    public List<ClientChat> getAllClientChatByChatStatus(String chatStatus) {
        return clientChatRepository.findAllClientChatByChatStatus(chatStatus);
    }
}

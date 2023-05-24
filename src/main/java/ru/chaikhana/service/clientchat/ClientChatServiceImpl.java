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

    @Override
    public List<ClientChat> getAllClientChatByTypeChatAndStatus(String chatType, String chatStatus) {
        return clientChatRepository.findAllClientChatByTypeChatAndChatStatus(chatType, chatStatus);
    }

    @Override
    public ClientChat getClientChatById(String id) {
        return clientChatRepository.findById(id).orElse(null);
    }

    @Override
    public ClientChat addClientChat(ClientChat clientChat) {
        return clientChatRepository.save(clientChat);
    }

    @Override
    public void deleteClientChat(ClientChat clientChat) {
        clientChatRepository.delete(clientChat);
    }

    @Override
    public ClientChat updateClientChat(ClientChat clientChat) {
        return clientChatRepository.save(clientChat);
    }

    @Override
    public List<ClientChat> getAllOpenNotBusyChat() {
        return clientChatRepository.findAllClientChatByChatStatus("isOpenNotBusy");
    }

    @Override
    public ClientChat getClientChat(String clientId) {
        return clientChatRepository.findClientChatByClientId(clientId).orElse(null);
    }
}

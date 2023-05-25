package ru.chaikhana.service.clientchat;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.chaikhana.model.Product;
import ru.chaikhana.model.chat.ClientChat;
import ru.chaikhana.repository.ClientChatRepository;

import java.util.List;

@Service
@Data
public class ClientChatServiceImpl implements ClientChatService {
    private final ClientChatRepository clientChatRepository;

    @Override
    public List<ClientChat> getAllClientChatByChatCategoryAndStatus(String chatCategory, String chatStatus) {
        return clientChatRepository.findAllClientChatByChatCategoryAndChatStatus(chatCategory, chatStatus);
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
    public ClientChat getClientChatByClientId(String clientId) {
        return clientChatRepository.findClientChatByClientId(clientId).orElse(null);
    }
    @Override
    public void changeClientChatCategory(String chatCategory, String clientId){
        ClientChat clientChat = getClientChatByClientId(clientId);
        clientChat.setChatCategory(chatCategory);
        updateClientChat(clientChat);
    }

    @Override
    public void changeClientChatStatus(String chatStatus, String clientId) {
        ClientChat clientChat = getClientChatByClientId(clientId);
        clientChat.setChatStatus(chatStatus);
        updateClientChat(clientChat);
    }

    @Override
    public void deleteProductInClientChat(Product product, String clientId) {
        ClientChat clientChat = getClientChatByClientId(clientId);
        if(clientChat!=null){
            clientChat.getClientProducts().remove(product);
            updateClientChat(clientChat);
        }
    }

    @Override
    public void addProductInClientChat(Product product, String clientId) {
        ClientChat clientChat = getClientChatByClientId(clientId);
        if(clientChat!=null){
            clientChat.getClientProducts().add(product);
            updateClientChat(clientChat);
        }
    }
}

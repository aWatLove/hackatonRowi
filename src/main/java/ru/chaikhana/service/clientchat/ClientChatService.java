package ru.chaikhana.service.clientchat;

import ru.chaikhana.model.chat.ClientChat;

import java.util.List;

public interface ClientChatService {
    List<ClientChat> getAllClientChatByChatCategoryAndStatus(String chatCategory, String chatStatus);

    ClientChat getClientChatById(String id);
    ClientChat addClientChat(ClientChat clientChat);
    void deleteClientChat(ClientChat clientChat);
    ClientChat updateClientChat(ClientChat clientChat);

    List<ClientChat> getAllOpenNotBusyChat();

    ClientChat getClientChatByClientId(String clientId);

    void changeClientChatCategory(String chatCategory, String clientId);

    void changeClientChatStatus(String chatStatus, String clientId);
}

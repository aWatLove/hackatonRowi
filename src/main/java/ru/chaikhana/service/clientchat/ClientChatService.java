package ru.chaikhana.service.clientchat;

import ru.chaikhana.model.chat.ClientChat;

import java.util.List;

public interface ClientChatService {
    List<ClientChat> getAllClientChatByChatStatus(String chatStatus);

    ClientChat getClientChatById(String id);
    ClientChat addClientChat(ClientChat clientChat);
    void deleteClientChat(ClientChat clientChat);
    ClientChat updateClientChat(ClientChat clientChat);
}

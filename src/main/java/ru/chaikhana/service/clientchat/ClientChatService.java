package ru.chaikhana.service.clientchat;

import ru.chaikhana.model.chat.ClientChat;

import java.util.List;

public interface ClientChatService {
    List<ClientChat> getAllClientChatByChatStatus(String chatStatus);
}

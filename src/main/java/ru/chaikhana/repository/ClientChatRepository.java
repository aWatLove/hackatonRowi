package ru.chaikhana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.chat.ChatStatus;
import ru.chaikhana.model.chat.ClientChat;

import java.util.List;

@Repository
public interface ClientChatRepository extends MongoRepository<ClientChat, String> {
    List<ClientChat> findAllClientChatByChatStatus(String chatStatus);
}

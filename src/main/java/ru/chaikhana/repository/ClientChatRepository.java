package ru.chaikhana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.chat.ChatStatus;
import ru.chaikhana.model.chat.ClientChat;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientChatRepository extends MongoRepository<ClientChat, String> {
    List<ClientChat> findAllClientChatByChatStatus(String chatStatus);
    List<ClientChat> findAllClientChatByChatCategoryAndChatStatus(String chatCategory, String chatStatus);
    Optional<ClientChat> findClientChatByClientId(String clientId);
}

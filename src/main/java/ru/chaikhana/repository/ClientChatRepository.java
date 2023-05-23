package ru.chaikhana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.chat.ClientChat;

@Repository
public interface ClientChatRepository extends MongoRepository<ClientChat, String> {
}

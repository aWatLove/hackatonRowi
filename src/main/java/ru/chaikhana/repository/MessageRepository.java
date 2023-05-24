package ru.chaikhana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}

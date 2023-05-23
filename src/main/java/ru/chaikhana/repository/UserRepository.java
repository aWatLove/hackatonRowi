package ru.chaikhana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

package ru.chaikhana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.chaikhana.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllUserByRole(String role);
    Optional<User> findUserByLogin(String login);
    void deleteUserById(String id);
}

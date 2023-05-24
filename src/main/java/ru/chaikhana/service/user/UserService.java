package ru.chaikhana.service.user;

import ru.chaikhana.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    List<User> getAllUserByRole(String role);

    User getUserById(String id);

    Optional<User> getUserByLogin(String login);

    User addUser(User user);

    void deleteUser(User user);

    void deleteUser(String id);

    User updateUser(User user);
}

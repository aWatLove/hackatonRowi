package ru.chaikhana.service.user;

import ru.chaikhana.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    List<User> getAllUserByRole(String role);
    User getUserById(String id);
    User getUserByLogin(String login);
    User addUser(User user);
    void deleteUser(User user);
    User updateUser(User user);
}

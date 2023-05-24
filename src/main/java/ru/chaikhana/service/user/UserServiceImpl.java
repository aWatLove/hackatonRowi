package ru.chaikhana.service.user;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.chaikhana.model.User;
import ru.chaikhana.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUserByRole(String role) {
        return userRepository.findAllUserByRole(role);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteUserById(id);
    }


    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}

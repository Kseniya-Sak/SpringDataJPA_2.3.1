package web.service;

import web.model.User;
import web.repositories.UserRepository;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> findAllUsers();
    User findUserById(int id);
}

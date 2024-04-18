package spring_mvc.dao;

import spring_mvc.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void editUser(User user);

    void deleteUser(int id);

    User getUser(int id);

    List<User> getAllUsers();

}

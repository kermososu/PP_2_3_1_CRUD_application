package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void create(User user);

    List<User> readAllUsers();

    void update(User user);

    void delete(long id);

    User getUserById(long id);

}

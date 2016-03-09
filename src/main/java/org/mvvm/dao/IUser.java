package org.mvvm.dao;

import org.mvvm.Pojo.User;

import java.util.List;

/**
 * @author amakarov
 */
public interface IUser {
    List<User> findAllUsers();
    User readUser(User user);
    void save(String login, String password);
}

package org.mvvm.services;

import org.mvvm.Pojo.User;

import java.util.List;

/**
 * @author amakarov
 */
public class ValidationService {
    private UserService userService;

    public ValidationService(UserService userService) {
        this.userService = userService;
    }

    public boolean isUser(String login, String password) {
        List<User> users = userService.findAllUsers();
        for (User user : users) {
            if (login.equals(user.getName()) && (password.equals(user.getPassword()))) {
                return true;
            }
        }
        return false;
    }

}

package org.mvvm;

import org.mvvm.Pojo.User;
import org.mvvm.dao.lists.UserDaoImpl;
import org.mvvm.services.UserService;
import org.mvvm.services.ValidationService;

import java.util.List;

/**
 * @author amakarov
 */
public class App {
    public static void main(String[] args) {
        UserService userService = new UserService(new UserDaoImpl());
        List<User> users = userService.findAllUsers();

        for (User user : users) {
            System.out.println(user);
        }

        ValidationService validationService = new ValidationService(userService);
        System.out.println(validationService.isUser("test", "test"));
    }
}

package org.mvvm.dao.lists;

import org.mvvm.Pojo.User;
import org.mvvm.dao.IUser;

import java.util.LinkedList;
import java.util.List;

/**
 * @author amakarov
 */
public class UserDaoImpl implements IUser {
    private List<User> userList = new LinkedList<User>();
    private static int id = 1;

    public UserDaoImpl(){
        userList.add(new User(id++, "test", "test"));
//        userList.add(new User(id++, "Vasya", "test"));
//        userList.add(new User(id++, "Petya", "123"));
    }


    public List<User> findAllUsers() {
        return userList;
    }

    @Override
    public User readUser(User user) {
        return userList.get(user.getId());
    }

    @Override
    public void save(String login, String password) {
        userList.add(new User(id++, login, password));
    }

}

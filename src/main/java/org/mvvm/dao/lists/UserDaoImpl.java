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
    private static Integer id = 1;

    public UserDaoImpl(){
        userList.add(new User(id++, "test", "test"));
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

    @Override
    public User editUser(User user) {
        userList.set(userList.indexOf(user), user);
        return user;
    }

    @Override
    public void remove(User user) {
        userList.remove(user);
    }

}

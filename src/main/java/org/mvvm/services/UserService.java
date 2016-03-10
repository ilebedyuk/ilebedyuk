package org.mvvm.services;

import org.mvvm.Pojo.User;
import org.mvvm.dao.IUser;

import java.util.List;

/**
 * @author amakarov
 */
public class UserService {
    private IUser iUser;

    public UserService(IUser iUser) {
        this.iUser = iUser;
    }

    public List<User> findAllUsers(){
        return iUser.findAllUsers();
    }

    public void save(String login, String password) {
        iUser.save(login,password);
    }

    public User editUser(User user){
        iUser.editUser(user);
        return user;
    }

    public void remove(User user){
        iUser.remove(user);
    }

//    public User findUserById(int id){
//        return iUser.readUser(id);
//    }
}

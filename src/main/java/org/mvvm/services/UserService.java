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

//    public User findUserById(int id){
//        return iUser.readUser(id);
//    }
}

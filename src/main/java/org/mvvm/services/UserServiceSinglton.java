package org.mvvm.services;


import org.mvvm.dao.lists.UserDaoImpl;

/**
 * @author amakarov
 */
public class UserServiceSinglton {

    private static final UserService INSTANCE = new UserService(new UserDaoImpl());

    public static UserService getInstance() {
        return INSTANCE;
    }

    private UserServiceSinglton() {
    }
}

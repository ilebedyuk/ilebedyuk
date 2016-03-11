package org.mvvm.services;


//import org.mvvm.dao.lists.UserDaoImpl;

import com.mongodb.MongoClient;
import org.mvvm.dao.mongodb.UserDaoImpl;

import java.net.UnknownHostException;

/**
 * @author amakarov
 */
public class UserServiceSinglton {

    private static UserService INSTANCE;

    public static UserService getInstance() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new UserService(new UserDaoImpl(new MongoClient()));
                //INSTANCE = new UserService(new UserDaoImpl());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    private UserServiceSinglton() {
    }
}

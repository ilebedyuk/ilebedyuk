package org.mvvm.dao.mongodb;

import com.mongodb.*;
import org.bson.types.ObjectId;
import org.mvvm.Pojo.User;
import org.mvvm.dao.IUser;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amakarov
 */
public class UserDaoImpl  implements IUser {
    private static DBCollection usersCol;
    public static DBCollection counters;

    public UserDaoImpl(MongoClient mongo) {

        this.usersCol = mongo.getDB("test").getCollection("users");
        this.counters = mongo.getDB("test").getCollection("counters");
    }

    public User createUser(User u) {
        DBObject doc = UserConvertor.toDBObject(u);
        this.usersCol.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        u.setId(Integer.parseInt(id.toString()));
        return u;
    }

    public List<User> findAllUsers() {
        List<User> data = new ArrayList<User>();
        DBCursor cursor = usersCol.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            User u = UserConvertor.toUser(doc);
            data.add(u);
        }
        return data;
    }

    public User readUser(User p) {
        //DBObject query = BasicDBObjectBuilder.start().append("_id", new ObjectId(p.getId())).get();
        DBObject query = BasicDBObjectBuilder.start().get();
        DBObject data = this.usersCol.findOne(query);
        return UserConvertor.toUser(data);
    }

    @Override
    public void save(String login, String password) {
        User user = new User(login, password);
        DBObject doc = UserConvertor.toDBObject(user);
        this.usersCol.insert(doc);
//        ObjectId id = (ObjectId) doc.get("_id");
//        user.setId(Integer.parseInt(id.toString()));
    }

    @Override
    public User editUser(User user) {
        DBObject query = BasicDBObjectBuilder.start()
        .append("_id", user.getId()).get();
        this.usersCol.update(query, UserConvertor.toDBObjectUpdate(user));
        return user;
    }

    @Override
    public void remove(User user) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", user.getId()).get();
        this.usersCol.remove(query);
       // this.usersCol.remove(new BasicDBObject().append("_id", user.getId()));
    }

    public static void main(String[] args) {
        try {
            UserDaoImpl userDao = new UserDaoImpl(new MongoClient());
            //userDao.save("Vasy", "12345");
            User user = new User("test", "test");
            userDao.save(user.getName(), user.getPassword());
            //userDao.remove(user);
            List<User> users = userDao.findAllUsers();
            for (User user1 : users) {
                System.out.println(user1);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

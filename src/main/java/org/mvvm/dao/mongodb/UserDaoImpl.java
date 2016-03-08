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
    //private MongoClient mongo = new MongoClient();
    private DBCollection col;

    public UserDaoImpl(MongoClient mongo) {
        this.col = mongo.getDB("test").getCollection("users");
    }

    public User createUser(User u) {
        DBObject doc = UserConvertor.toDBObject(u);
        this.col.insert(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        u.setId(id.toString());
        return u;
    }

    public void updateUser(User u) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(String.valueOf(u.getId()))).get();
        this.col.update(query, UserConvertor.toDBObject(u));
    }

    public List<User> findAllUsers() {
        List<User> data = new ArrayList<User>();
        DBCursor cursor = col.find();
        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            User u = UserConvertor.toUser(doc);
            data.add(u);
        }
        return data;
    }

    public void deletePerson(User u) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(String.valueOf(u.getId()))).get();
        this.col.remove(query);
    }

    public User readUser(User p) {
        DBObject query = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(String.valueOf(p.getId()))).get();
        DBObject data = this.col.findOne(query);
        return UserConvertor.toUser(data);
    }

    public static void main(String[] args) {
        try {
            UserDaoImpl userDao = new UserDaoImpl(new MongoClient());
            List<User> users = userDao.findAllUsers();
            for (User user : users) {
                System.out.println(users);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

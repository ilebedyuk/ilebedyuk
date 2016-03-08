package org.mvvm.dao.mongodb;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.mvvm.Pojo.User;

/**
 * @author amakarov
 */
public class UserConvertor {
    // convert Person Object to MongoDB DBObject
    // take special note of converting id String to ObjectId
    public static DBObject toDBObject(User u) {

        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("_id", new ObjectId(String.valueOf(u.getId())))
                .append("name", u.getName()).append("password", u.getPassword());
        return builder.get();
    }

    // convert DBObject Object to Person
    // take special note of converting ObjectId to String
    public static User toUser(DBObject doc) {
        User u = new User();
        u.setName((String) doc.get("name"));
        u.setPassword((String) doc.get("password"));
        String id1 = ((String) doc.get("_id"));
        u.setId(id1);
        return u;
    }

}

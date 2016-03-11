package org.mvvm.dao.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.mvvm.Pojo.User;

/**
 * @author amakarov
 */
public class UserConvertor {
    //public static DBCollection counters;
    //private static Integer id = 1;

    // convert Person Object to MongoDB DBObject
    // take special note of converting id String to ObjectId
    public static DBObject toDBObject(User u) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("name", u.getName()).append("password", u.getPassword());
            builder = builder.append("_id", getNextSequence("userid"));
        return builder.get();
    }

    public static DBObject toDBObjectUpdate(User u) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("name", u.getName()).append("password", u.getPassword());
            builder = builder.append("_id", u.getId());
        return builder.get();
    }

    private static Object getNextSequence(String name) {
        BasicDBObject searchQuery = new BasicDBObject("_id", name);
        BasicDBObject increase = new BasicDBObject("seq", 1);
        BasicDBObject updateQuery = new BasicDBObject("$inc", increase);
        DBObject result = UserDaoImpl.counters.findAndModify(searchQuery, null, null,
                false, updateQuery, true, false);

        return result.get("seq");
    }

    // convert DBObject Object to Person
    // take special note of converting ObjectId to String
    public static User toUser(DBObject doc) {
        User u = new User();
        u.setName((String) doc.get("name"));
        u.setPassword((String) doc.get("password"));
        Integer mongoId = (Integer) doc.get("_id");
        u.setId(mongoId);
        return u;
    }

}

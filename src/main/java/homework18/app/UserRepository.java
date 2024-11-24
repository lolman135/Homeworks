package homework18.app;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<User> userList = null;

    public static void addUser(User user){
        if (userList == null){
            userList = new ArrayList<>();
        }
        userList.add(user);
    }
}

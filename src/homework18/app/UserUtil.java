package homework18.app;

import java.util.List;
import java.util.Optional;

public class UserUtil {

    public static Optional<User> getByUserId(String id) {
        return Optional.ofNullable(UserRepository.userList)
                .flatMap(list -> list.stream().filter(user -> user.getId()
                        .equals(id))
                        .findFirst());
    }

    public static Optional<User> getByUserEmail(String email) {
        return Optional.ofNullable(UserRepository.userList)
                .flatMap(list -> list.stream().filter(user -> user.getEmail()
                        .equals(email))
                        .findFirst());
    }

    public static Optional<List<User>> findAllUsers(){
        return Optional.ofNullable(UserRepository.userList);
    }


}

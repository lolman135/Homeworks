package homework18.app;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();

        User user1 = new User(id1, "Max", "abc@gmail.com");
        User user2 = new User(id2, "John", "124@gmail.com");
        User user3 = new User(id3, "Alex", "postpunk@gmail.com");

        UserRepository.addUser(user1);
        UserRepository.addUser(user2);
        UserRepository.addUser(user3);

        UserUtil.getByUserId(id2).ifPresent(System.out::println);
        UserUtil.getByUserEmail("postpunk@gmail.com").ifPresent(System.out::println);
        UserUtil.findAllUsers().ifPresent(list -> System.out.println("Size of user repository: " + list.size()));
    }
}

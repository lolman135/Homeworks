package homework26.app;

public class Main {

    public static void main(String[] args) {
        Address address1 = new Address("13a", "Pivovarska", "Lviv");
        User user1 = new User("Max", 23, address1);
        System.out.println(user1.getAddress());

        user1.setAddress("34", "Adamovicha", "Lutsk");
        System.out.println(user1.getAddress());

        User user2 =  new User("Leo", 19, "1", "Central", "Dnipro");
        System.out.println(user2.getAddress());

        Address address2 = new Address("82", "Livoberezhna", "Kyiv");
        user2.setAddress(address2);
        System.out.println(user2.getAddress());

        System.out.println("\n" + user2);
    }
}

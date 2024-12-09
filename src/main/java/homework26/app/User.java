package homework26.app;

public class User {

    private String name;
    private int age;
    private Address address;

    public User(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public User(String name, int age, String houseNumber, String street, String locality){
        this.name = name;
        this.age = age;
        this.address = new Address(houseNumber, street, locality);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress(String houseNumber, String street, String locality){
        this.address = new Address(houseNumber, street, locality);
    }

    @Override
    public String toString() {
        return "User:" +
                "\n •name: " + name + ';' +
                "\n •age: " + age + ';' +
                "\n •address: " + address + ';'
                ;
    }
}

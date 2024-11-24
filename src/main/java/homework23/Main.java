package homework23;

import app.PasswordGenerator;

public class Main {

    public static void main(String[] args) {
        String password = PasswordGenerator.generatePassword(10);
        System.out.println(password);
    }

}

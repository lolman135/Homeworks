package carRacing.app;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {

        CountDownLatch finish = new CountDownLatch(5);
        AtomicBoolean isWinner = new AtomicBoolean(false);

        Car car1 = new Car("Car 1", finish, isWinner);
        Car car2 = new Car("Car 2", finish, isWinner);
        Car car3 = new Car("Car 3", finish, isWinner);
        Car car4 = new Car("Car 4", finish, isWinner);
        Car car5 = new Car("Car 5", finish, isWinner);

        for(int i = 3; i > 0; i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();

        try {
            finish.await();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Race was finished and we have the winner!");
    }
}

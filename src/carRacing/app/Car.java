package carRacing.app;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car extends Thread{

    private final String name;
    private final CountDownLatch finish;
    private final AtomicBoolean isWinner;

    public Car(String name, CountDownLatch finish, AtomicBoolean isWinner) {
        super(name);
        this.name = name;
        this.finish = finish;
        this.isWinner = isWinner;
    }

    @Override
    public void run() {
        System.out.println(name + " started");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(name +" has finished race!");

        if(isWinner.compareAndSet(false, true)){
            System.out.println(name + " won that race!");
        }

        finish.countDown();
    }
}

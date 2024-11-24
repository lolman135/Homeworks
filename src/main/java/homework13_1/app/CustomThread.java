package homework13_1.app;

import java.util.concurrent.Semaphore;

public class CustomThread extends Thread {

    private Semaphore sem;
    private String name;
    private DataHandler dataHandler;
    private int[] numbers;

    public CustomThread(String name, Semaphore sem, DataHandler dataHandler, int[] numbers) {
        super(name);
        this.name = name;
        this.sem = sem;
        this.dataHandler = dataHandler;
        this.numbers = numbers;
    }

    @Override
    public void run() {
        if (this.getName().equals("Alpha")) {
            dataOperate(3);
        } else {
            dataOperate(5);
        }
    }

    private void dataOperate(int coefficient) {
        System.out.println(name + " started");
        try {
            sem.acquire();
            System.out.println(name + " got permit\n");
            for (int number : numbers) {
                System.out.println("Initial value is " + number);
                int newNum = dataHandler.modify(number, coefficient);
                System.out.println("New value is " + newNum);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        sem.release();
        System.out.println("\n" + name + " released permit\n" +
                "======================================");
    }
}

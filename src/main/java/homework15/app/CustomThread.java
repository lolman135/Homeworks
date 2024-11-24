package homework15.app;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CustomThread extends Thread{

    private Semaphore sem = new Semaphore(1);
    private UIOperator operator;
    private DataHandler handler;
    private String name;
    private int[] idCodes;

    public CustomThread(String name, DataHandler handler, Semaphore sem, UIOperator operator, int[] idCodes) {
        super(name);
        this.name = name;
        this.idCodes = idCodes;
        this.handler = handler;
        this.sem = sem;
        this.operator = operator;
    }

    @Override
    public void run() {
        System.out.println(name + " started");

        try{
            sem.acquire();
            operator.getOutput(name + " got a permit");
            operator.getOutput(handler.getAll());
            Random random = new Random();
            int index = random.nextInt(3);
            operator.getOutput(handler.getById(idCodes[index]));

        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        sem.release();
        operator.getOutput(name + " relesed the permit\n");
    }
}

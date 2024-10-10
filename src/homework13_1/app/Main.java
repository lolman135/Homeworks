package homework13_1.app;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new DataRepository().getData();
        DataHandler dataHandler = new DataHandler();
        Semaphore sem = new Semaphore(1);

        CustomThread thread1 = new CustomThread("Alpha", sem, dataHandler, numbers);
        CustomThread thread2 = new CustomThread("Beta", sem, dataHandler, numbers);

        thread1.run();
        thread2.run();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }
}

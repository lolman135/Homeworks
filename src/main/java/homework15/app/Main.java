package homework15.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        DataHandler handler = new DataHandler();
        UIOperator uiOperator = new UIOperator();
        int[] idCodes = DataRepository.getIdCodes();
        Semaphore sem = new Semaphore(1);

        List<CustomThread> list = new ArrayList<>();

        CustomThread thread1 = new CustomThread("Thread-1", handler, sem, uiOperator, idCodes);
        CustomThread thread2 = new CustomThread("Thread-2", handler, sem, uiOperator, idCodes);
        CustomThread thread3 = new CustomThread("Thread-3", handler, sem, uiOperator, idCodes);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);

        list.forEach(elem -> elem.run());

    }
}

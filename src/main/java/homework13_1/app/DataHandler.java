package homework13_1.app;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final Lock locker = new ReentrantLock();

    public int modify(int num, int coefficient){
        return num*coefficient;
    }
}

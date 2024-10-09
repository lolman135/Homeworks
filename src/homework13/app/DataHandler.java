package homework13.app;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataHandler {

    private final Lock locker = new ReentrantLock();

    public synchronized int modify(int num){
        locker.lock();
        try{
            return num*3;
        } finally {
            locker.unlock();
        }
    }
}

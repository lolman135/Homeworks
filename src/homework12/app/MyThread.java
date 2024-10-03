package homework12.app;

import java.util.TreeMap;

public class MyThread extends Thread {

    DataHandler dataHandler;

    public MyThread(String name, DataHandler dataHandler) {
        super(name);
        this.dataHandler = dataHandler;
    }

    @Override
    public void run() {
        dataHandler.getOutput();
    }
}

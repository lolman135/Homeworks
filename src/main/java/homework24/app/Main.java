package homework24.app;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("INFO", "starting program");
        logger.log("INFO", "creating new logger");
        Logger logger1 = Logger.getInstance();
        logger1.log("INFO", "some info from new logger");
        logger1.close();
        logger.close();
    }
}

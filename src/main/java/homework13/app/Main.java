package homework13.app;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new DataRepository().getData();
        DataHandler dataHandler = new DataHandler();

        for (int number : numbers) {
            System.out.println("Initial value is " + number);
            int newNum = dataHandler.modify(number);
            System.out.println("New value is " + newNum);
        }
    }
}

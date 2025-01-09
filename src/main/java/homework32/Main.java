package homework32;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        try{
            orderBoard.add("Radomir");
            orderBoard.add("Leo");
            orderBoard.add("Markus");
            orderBoard.add("Tyrion");

            orderBoard.draw();

            Order order = orderBoard.deliver();
            System.out.println(order);
            Order order2 = orderBoard.deliver();
            System.out.println(order2);

            System.out.println(orderBoard.deliver(5));
        } catch (Exception e){
            System.out.println("Something went wrong");
            LOGGER.error("Error: wrong operation with board", e);
        }
    }
}

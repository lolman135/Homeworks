package homework32;

import lombok.Getter;
import lombok.ToString;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class CoffeeOrderBoard {

    private final List<Order> orders;
    private int nextOrderNumber;

    private static final Logger LOGGER = Logger.getLogger(CoffeeOrderBoard.class.getName());

    public CoffeeOrderBoard(){
        this.orders = new ArrayList<>();
        this.nextOrderNumber = 1;
    }

    public void add(String customerName){
        orders.add(new Order(customerName, nextOrderNumber));
        LOGGER.info("added new order with number=" + nextOrderNumber + " and customer name " + customerName);
        nextOrderNumber++;
    }

    public Order deliver(){
        LOGGER.warn("Attempting to get order from queue");
        if (orders.isEmpty()){
            throw new EmptyListException("Trying to get element from the empty list!");
        }

        int indexOfMinElement = 0;
        for(int i = 1; i < orders.size(); i++){
            if (orders.get(i).getNumber() < orders.get(indexOfMinElement).getNumber()){
                indexOfMinElement = i;
            }
        }
        LOGGER.info("Got first element order the queue");
        return orders.remove(indexOfMinElement);
    }

    public Order deliver(int number){
        for (int i = 0; i < orders.size(); i++){
            if (number == orders.get(i).getNumber()){
                LOGGER.info("Got element with number " + number + " from the queue");
                return orders.remove(i);
            }
        }
        throw new IllegalArgumentException("Wrong index!");
    }

    public void draw(){
        System.out.println("Num | Name");
        for (Order order : orders){
            System.out.println(" " + order.getNumber() + "  | " + order.getCustomerName());
        }
    }
}

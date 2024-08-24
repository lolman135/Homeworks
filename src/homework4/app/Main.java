package homework4.app;

public class Main {
    public static void main(String[] args) {
        Customer customer = getCusomer(getData());
        String customerInfo = "Customer: " + customer.getName() +
                ", phone " + customer.getPhone();
        getOutput(customerInfo);
    }

    public static String[] getData(){
        return new String[]{"Joe Ronald", "+43032992842"};
    }

    public static Customer getCusomer(String[] dataArray){
        return new Customer(dataArray[0], dataArray[1]);
    }

    public static void getOutput(String outputData){
        System.out.println(outputData);
    }
}




package linkedListTask;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> listNames = new LinkedList<>();
        addFrom(listNames, DataRepository.names);
        System.out.println("LinkedList with names:\n" + listNames + "\n");

        LinkedHashSet<String> namesSet = new LinkedHashSet<>(listNames);
        System.out.println("HashSet with unique names:\n" + namesSet + "\n");

        LinkedHashSet<String> duplicatesNames = HashSetOperator.findDuplicates(listNames);
        System.out.println("Unique duplicates:\n" + duplicatesNames + "\n");

        System.out.println("Reversed unique duplicates:\n" + duplicatesNames.reversed() + "\n");
    }

    private static void addFrom(LinkedList<String> list, String[] data){
        for (String datum : data) {
            list.add(datum);
        }
    }
}

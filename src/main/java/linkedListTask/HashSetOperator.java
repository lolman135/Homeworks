package linkedListTask;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class HashSetOperator {

    public static LinkedHashSet<String> findDuplicates(LinkedList<String> list) {
        LinkedHashSet<String> duplicates = new LinkedHashSet<>();
        LinkedHashSet<String> seenTemp = new LinkedHashSet<>();

        for (String name : list) {
            if (seenTemp.contains(name)){
                duplicates.add(name);
            }
            seenTemp.add(name);
        }

        return duplicates;
    }
}

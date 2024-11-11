package homework19.app;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = ArrayUtils.generateArray(20, 1, 100);
        System.out.println("Before sorting: " + Arrays.toString(array));

        ArrayUtils.mergeSort(array);
        System.out.println("After sorting: " + Arrays.toString(array));

        int element = 10;
        int index = ArrayUtils.binarySearch(array, element);
        System.out.println(index != -1 ? "Element " + element + " contains at position " + index :
                "Error: no such element!");
    }
}

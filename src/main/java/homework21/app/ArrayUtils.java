package homework21.app;

public class ArrayUtils {

    @MethodInfo(name = "generateArray", returnType = int[].class, description = "generates array with random numbers")
    @Author(name = "Kyrylo", surname = "Kusovskyi")
    public static int[] generateArray(int size, int minVal, int maxVal){
        int[] arr = new int[size];

        for (int i = 0; i < size; i++){
            arr[i] = (int) (Math.random() * (maxVal - minVal + 1)) + minVal;
        }

        return arr;
    }

    @MethodInfo(name = "binarySearch", returnType = int.class, description = "return index of element need to find")
    @Author(name = "Kyrylo", surname = "Kusovskyi")
    public static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] < target){
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

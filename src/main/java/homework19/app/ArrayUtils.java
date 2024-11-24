package homework19.app;

public class ArrayUtils {


    public static int[] generateArray(int size, int minVal, int maxVal){
        int[] arr = new int[size];

        for (int i = 0; i < size; i++){
            arr[i] = (int) (Math.random() * (maxVal - minVal + 1)) + minVal;
        }

        return arr;
    }

    //sorting
    public static void mergeSort(int[] arr){
        sort(arr, 0, arr.length -1);
    }

    private static void sort(int[] arr, int low, int high){
        if (low < high){
            int mid = (low + high)/2;

            sort(arr, low, mid);
            sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] subArr, int low, int  mid, int high){
        int n = high - low + 1;
        int[] tempArr = new int[n];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while(i <= mid || j <= high){
            if (i > mid){
                tempArr[k++] = subArr[j++];
            } else if(j > high){
                tempArr[k++] = subArr[i++];
            } else if (subArr[i] < subArr[j]) {
                tempArr[k++] = subArr[i++];
            } else {
                tempArr[k++] = subArr[j++];
            }
        }

        for (j = 0; j < n; j++){
            subArr[low + j] = tempArr[j];
        }
    }

    //finding element
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

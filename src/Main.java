import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array1[i] = (int) (Math.random() * 10000);
        }

        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);

        long startTime = System.nanoTime();
        bubbleSort(array1);
        long endTime = System.nanoTime();
        long durationOfSort = (endTime - startTime);
        System.out.println(durationOfSort);

        startTime = System.nanoTime();
        quickSort(array2, 0, array2.length - 1);
        endTime = System.nanoTime();
        durationOfSort = (endTime - startTime);
        System.out.println(durationOfSort);

        startTime = System.nanoTime();
        Arrays.sort(array3);
        endTime = System.nanoTime();
        durationOfSort = (endTime - startTime);
        System.out.println(durationOfSort);

    }

    static void bubbleSort(int[] arr) {
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp =  arr[i];
                    arr[i] = arr[i +1];
                    arr[i + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

}
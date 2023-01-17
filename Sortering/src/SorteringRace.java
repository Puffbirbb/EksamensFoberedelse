import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SorteringRace {
    public static void main(String[] args) {

        Random r = new Random();

        int[] ints = r.ints(100000, 1, 10000000).toArray();
        int[] numbersBubble = ints.clone();
        int[] numbersSelection = ints.clone();
        int[] numbersInsertion = ints.clone();
        int[] numbersQuick = ints.clone();

        StopWatch timer = new StopWatch();

        timer.start();
        bubbleSort(numbersBubble);
        timer.stop();

        System.out.printf("[BUBBLESORT] Elapsed milliseconds:%4d%n", timer.getElapsedTime());
        //System.out.println(Arrays.toString(numbersBubble));
        timer.reset();

        timer.start();
        selectionSort(numbersSelection);
        timer.stop();

        System.out.printf("[SELECTIONSORT] Elapsed milliseconds:%8d%n", timer.getElapsedTime());
        //System.out.println(Arrays.toString(numbersSelection));
        timer.reset();

        timer.start();
        insertionSort(numbersInsertion);
        timer.stop();

        System.out.printf("[INSERTIONSORT] Elapsed milliseconds:%8d%n", timer.getElapsedTime());
        //System.out.println(Arrays.toString(numbersInsertion));
        timer.reset();

        timer.start();
        int n = numbersQuick.length;
        quickSort(numbersQuick, 0, n-1);
        timer.stop();

        System.out.printf("[QUICKSORT] Elapsed milliseconds:%8d%n", timer.getElapsedTime());
        //System.out.println(Arrays.toString(numbersQuick));
        timer.reset();
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i){
                int temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];

        int i = (low - 1);

        for (int  j = low; j <= high - 1; j++){
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}

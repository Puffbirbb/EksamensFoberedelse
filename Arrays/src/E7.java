import java.util.Arrays;

public class E7 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8, 12, 19, 22};

        //Opg1
        System.out.println("Before Swap: " + Arrays.toString(arr));

        firstToLast(arr);

        System.out.println("After Swap: " + Arrays.toString(arr));

        System.out.println("-------------------");

        int[] equal0 = {1, 3, 4, 8, 12, 19, 22};

        System.out.println("Before Swap: " + Arrays.toString(equal0));

        unevenEqualizer(equal0);

        System.out.println("After Swap: " + Arrays.toString(equal0));

        System.out.println("-------------------");

        int[] sH = {1, 3, 4, 8, 12, 19, 22};
        System.out.println(secondHighest(sH));

        System.out.println("-------------------");

        int[] sorted = {1, 3, 4, 8, 12, 19, 22};
        System.out.println("Expected: True - Answer = " + sortedOrNot(sorted));

        int[] notSorted = {1, 6, 4, 8, 12, 19, 22};
        System.out.println("Expected: False - Answer = " + sortedOrNot(notSorted));

        System.out.println("-------------------");

        int[] right = {1, 3, 4, 8, 12, 19, 22};

        System.out.println("Before Righted: " + Arrays.toString(right));

        toTheRight(right);

        System.out.println("After Righted: " + Arrays.toString(right));

        System.out.println("-------------------");

        int[] no = {1, 3, 4, 8, 12, 19, 22};
        System.out.println("Expected: False - Answer = " + duplicationDetector(no));

        int[] yes = {1, 3, 4, 8, 12, 19, 12};
        System.out.println("Expected: True - Answer = " + duplicationDetector(yes));
    }

    public static void firstToLast(int[] arr){
        int first = arr[0];
        int last = arr[arr.length - 1];
        arr[0] = last;
        arr[arr.length - 1] = first;
    }

    public static void unevenEqualizer(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0){
                arr[i] = 0;
            }
        }
    }

    public static int secondHighest(int[] arr){
        int sH = 0;
        int H = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > H){
                sH = H;
                H = arr[i];
            }
        }
        return sH;
    }

    public static boolean sortedOrNot(int[] arr){
        int last = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < last) {
                return false;
            }
            last = arr[i];
        }
        return true;
    }

    public static void toTheRight(int[] arr){
        int last = arr[arr.length-1];
        for (int i = arr.length-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }

    public static boolean duplicationDetector(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] == arr[i]){
                    return true;
                }
            }
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.Arrays;

public class SearchAndSwap {
    public static void main(String[] args) {
        int[] la = {6, 4, 8, 13, 7};
        System.out.println(linearSearch(la, 13));
        System.out.println(Arrays.toString(la));

        ArrayList ala = new ArrayList<>();

        ala.add(6);
        ala.add(4);
        ala.add(8);
        ala.add(13);
        ala.add(7);

        System.out.println(linearSearchList(ala, 13));
        System.out.println(ala);
    }

    public static int linearSearch(int[] arr, int target){
        int temp;
        int index = -1;
        int i = 0;
        while (index == -1 && i < arr.length){
            int k = arr[i];
            if (k == target){
                temp = arr[i - 1];
                arr[i - 1] = k;
                arr[i] = temp;
                index = i - 1;
            }
            else
                i++;
        }
        return index;
    }

    public static int linearSearchList(ArrayList<Integer> list, int target){
        int index = -1;
        int temp;
        int i = 0;
        while (index == -1 && i < list.size()){
            int k = list.get(i);
            if (k == target){
                temp = list.get(i - 1);
                list.set(i - 1, k);
                list.set(i, temp);
                index = i - 1;
            }
            else
                i++;
        }
        return index;
    }
}

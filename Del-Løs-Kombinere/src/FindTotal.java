import java.util.ArrayList;
import java.util.List;

public class FindTotal {
    public static void main(String[] args) {
        ArrayList hunna = new ArrayList(List.of(45, 17, 82, 91, 53, 28, 0, 0));

        System.out.println(sum(hunna));

        System.out.println(zero(hunna));

        mergesort(hunna);

        System.out.println(hunna);
    }

    public static int sum(ArrayList<Integer> list) {
        return totalInList(list, 0, list.size() - 1);
    }

    private static int totalInList(ArrayList<Integer> list, int l, int h){
        if (l == h) {
            return list.get(l);
        } else {
            int total = 0;
            int m = (l + h) / 2;
            int totalL = total + totalInList(list, l, m);
            int totalH = total + totalInList(list, m + 1, h);
            total += totalL + totalH;
            return total;
        }
    }

    public static int zero(ArrayList<Integer> list) {
        return zeroInList(list, 0, list.size() - 1);
    }

    private static int zeroInList(ArrayList<Integer> list, int l, int h){
        int total = 0;
        if (l == h) {
            if (list.get(l) == 0){
                total++;
            }
        } else {
            int m = (l + h) / 2;
            int totalL = zeroInList(list, l, m);
            int totalH = zeroInList(list, m + 1, h);
            total += totalL + totalH;
        }
        return total;
    }

    public static void mergesort(ArrayList<Integer> list){
        mergesort(list, 0, list.size()-1);
    }

    private static void mergesort(ArrayList<Integer> list, int l, int h) {
        if (l < h){
            int m = (l + h) / 2;
            mergesort(list, l, m);
            mergesort(list, m + 1, h);
            merge(list, l, m, h);
        }
    }

    private static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = low, j = middle + 1;
        while (i <= middle && j <= high){
            if (list.get(i) <= list.get(j)){
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }
        while (i <= middle){
            temp.add(list.get(i));
            i++;
        }
        while (j <= high){
            temp.add(list.get(j));
            j++;
        }
        for(int l = 0; l < temp.size(); low++){
            list.set(low, temp.get(l++));
        }
    }
}

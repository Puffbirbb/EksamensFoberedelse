import java.util.ArrayList;
import java.util.Arrays;

public class Butik {
    public static void main(String[] args) {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        Customer[] badCustomer = new Customer[4];

        Customer c1 = new Customer("Bent");
        Customer c2 = new Customer("Kaj");
        Customer c3 = new Customer("Lise");
        Customer c4 = new Customer("Jane");
        Customer c5 = new Customer("Jesper");
        Customer c6 = new Customer("Carsten");
        Customer c7 = new Customer("Laura");
        Customer c8 = new Customer("Søren");
        Customer c9 = new Customer("Albert");
        Customer c10 = new Customer("Christians Mor "); // is ugly
        Customer c11 = new Customer("Christians Far "); // is ugly


        allCustomers.add(c1);
        allCustomers.add(c2);
        allCustomers.add(c3);
        allCustomers.add(c4);
        allCustomers.add(c5);
        allCustomers.add(c6);
        allCustomers.add(c7);
        allCustomers.add(c8);
        allCustomers.add(c9);
        allCustomers.add(c10);
        allCustomers.add(c11);

        badCustomer[0] = c7;
        badCustomer[1] = c8;
        badCustomer[2] = c9;
        badCustomer[3] = c10;

        insertionSortA(badCustomer);
        insertionSortAL(allCustomers);

        System.out.println(goodCustomers(allCustomers, badCustomer));
    }

    public static void insertionSortAL(ArrayList<Customer> al){
        for (int i = 1; i < al.size(); i++){
            Customer temp = al.get(i);
            int j = i;
            while (j > 0 && temp.compareTo(al.get(j-1)) < 0) {
                al.set(j, al.get(j-1));
                j--;
            }
            al.set(j, temp);
        }
    }

    public static void insertionSortA(Customer[] arr){
        for (int i = 1; i < arr.length; i++){
            Customer temp = arr[i];
            int j = i;
            while (j > 0 && temp.compareTo(arr[j-1]) < 0) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static ArrayList<Customer> goodCustomers (
            ArrayList<Customer> s1, Customer[] s2){
        ArrayList<Customer> goodBoys = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.size() && i2 < s2.length){
            if (s1.get(i1).compareTo(s2[i2]) == 0){
                i1++;
                i2++;
            } else if (s1.get(i1).compareTo(s2[i2]) < 0){
                goodBoys.add(s1.get(i1));
                i1++;
            }
        }
        return goodBoys;
    }
}

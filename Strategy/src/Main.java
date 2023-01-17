import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Lars", 1);
        Customer c2 = new Customer("Zenzangindo", 972634);
        Customer c3 = new Customer("ABC", 9);
        Customer c4 = new Customer("Z", 191919);

        ArrayList<Customer> list = new ArrayList<>(List.of(c1, c2, c3, c4));
        System.out.println("Raw output: " + list);

        Customer.setComp(new CompareName());
        Collections.sort(list);
        System.out.println("Compare Name: " + list);

        Customer.setComp(new CompareNumber());
        Collections.sort(list);
        System.out.println("Compare Number: " + list);
    }
}

package observer_ex3student;

import java.util.ArrayList;
import java.util.List;

public class TestApp {

    public static void main(String[] args) {
        Purchaser p1 = new Purchaser("Jørgen");
        Salesman s1 = new Salesman("Birgitte");

        Book b1 = new Book("Donald Duck");
        b1.addObserver(p1);
        b1.addObserver(s1);

        p1.purchaseBook(b1, 6);
        System.out.println();

        Book b2 = new Book("Java");
        b2.addObserver(p1);
        b2.addObserver(s1);

        p1.purchaseBook(b2, 8);
        System.out.println();

        Book b3 = new Book("Design Patterns");
        b3.addObserver(p1);
        b3.addObserver(s1);

        p1.purchaseBook(b3, 10);
        System.out.println();

        Customer c1 = new Customer("Bob");
        Customer c2 = new Customer("Alice");
        Customer c3 = new Customer("Harry");

        ArrayList<Customer> customers = new ArrayList<>(List.of(c1, c2, c3));
        //---------------------------------------------------------------------

        TestApp.makeSale(b1, c1);
        System.out.println();
        TestApp.makeSale(b1, c2);
        System.out.println();
        TestApp.makeSale(b1, c3);
        System.out.println();

        TestApp.makeSale(b2, c1);
        System.out.println();
        TestApp.makeSale(b2, c2);
        System.out.println();
        TestApp.makeSale(b2, c3);
        System.out.println();

        TestApp.makeSale(b3, c1);
        System.out.println();

        for(Customer e : customers){
            System.out.println(e.getBooks());
        }
    }

    public static void makeSale(Book b, Customer c) {
        System.out.println("Sale: " + b + " sold to " + c.getName());
        b.addCustomer(c);
        b.decCount(1);
    }
}

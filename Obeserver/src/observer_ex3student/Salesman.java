package observer_ex3student;

import java.util.HashSet;
import java.util.Set;

public class Salesman implements BookObserver {
    private final String name;

    public Salesman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Book book) {
        Set<Book> alsoBought = new HashSet<>();
        for (Customer c : book.getCustomers()){
            alsoBought.addAll(c.getBooks());
        }
        alsoBought.remove(book);
        for (Book b : alsoBought){
            System.out.println(b);
        }
    }
}

import java.util.Comparator;

public class Customer implements Comparable<Customer>{
    private final String name;
    private final int number;
    private static Comparator<Customer> comp;

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Customer (String name, int number){
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "name = '" + name + '\'' +
                ", number = " + number;
    }

    public static Comparator<Customer> getComp() {
        return comp;
    }

    public static void setComp(Comparator<Customer> comp) {
        Customer.comp = comp;
    }

    @Override
    public int compareTo(Customer o) {
        return comp.compare(this,o);
    }
}

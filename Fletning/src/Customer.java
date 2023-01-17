public class Customer implements Comparable<Customer> {
    private final String name;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Customer customer) {
        return Integer.compare(this.name.compareTo(customer.name), 0);
    }

}

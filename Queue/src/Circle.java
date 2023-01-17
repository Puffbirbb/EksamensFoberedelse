import java.util.Random;

public class Circle {

    private Node head;
    private Node tail;
    private Node current;
    private int count;

    public Circle() {
        head = null;
        tail = null;
        count = 0;
    }

    public void addPerson(Person p){
        Node newNode = new Node(p);
        if (head == null){
            head = newNode;
            current = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
        count++;
    }

    public void printPersons() {
        if (head == null){
            System.out.println("They Have All Been Eaten.");
        }
        Node node = current;
        for (int i = 0; i < count; i++){
            System.out.println(node.entry.getName());
            node = node.next;
        }
    }

    public String removeFirst() {
        Node node = head;
        Random r = new Random();
        int chosen = r.nextInt(count);
        for (int i = 0; i < chosen - 1; i++){
            node = node.next;
        }
        Person removed;
        removed = node.next.entry;
        node.next = node.next.next;
        current = node;
        count--;
        return removed.getName();
    }

    public String removeNext(int chosen) {
        Node node = current;
        System.out.println("The Count is " + chosen);
        for(int i = 0; i < chosen - 1; i++){
            System.out.println(node.next.entry.getName() + " Got Lucky.");
            node = node.next;
        }
        Person removed = node.next.entry;
        node.next = node.next.next;
        current = node;
        count--;
        return removed.getName();
    }

    private class Node {
        private Person entry;
        private Node next;

        public Node(Person entry) {
            this.entry = entry;
            this.next = null;
        }
    }
}

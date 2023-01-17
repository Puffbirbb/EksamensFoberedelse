import java.util.NoSuchElementException;

public class SingleLinkedList {

    private Node first;

    // Sorted
    public SingleLinkedList() {
        first = null;
    }

    /**
     * Add the element to the list.
     * The list is still sorted after the element is added.
     */
    public void add(String element) {
        Node newNode = new Node(element);
        if (first == null || first.data.compareTo(element) > 0){
            newNode.next = first;
            first = newNode;
            return;
        }

        Node node = first;
        boolean placed = false;
        while (!placed && node.next != null){
            if (node.next.data.compareTo(element) >= 0){
                newNode.next = node.next;
                node.next = newNode;
                placed = true;
            }
            node = node.next;
        }

        if (!placed){
            node.next = newNode;
        }
    }

    /**
     * Remove the last element from the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed, otherwise false.
     */
    public boolean removeLast(){
        if (first == null){
            return false;
        }

        if(first.next == null){
            first = null;
            return true;
        }

        Node node = first;
        while (node.next != null){
            if(node.next.next == null){
                node.next = null;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Remove the first instance of the element from the list.
     * The list is still sorted after the element is removed.
     * Return true, if the element was removed, otherwise false.
     */
    public boolean remove(String element){
        if (first == null){
            return false;
        }

        if (first.data.equals(element)){
            first = null;
            return true;
        }

        Node node = first;
        while (node.next != null){
            if (node.next.data.equals(element)){
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Print all elements in alphabetical order.
     */
    public void printElements() {
        if (first == null){
            System.out.println("Empty List DumbAss?");
            return;
        }

        Node node = first;
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     * Return the count of elements in the list.
     */
    public int count() {
        int count = 0;
        if (first == null){
            return count;
        }

        Node node = first;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    private class Node {
        private String data;
        private Node next;
        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();

        sll.add("Nigger");
        sll.add("NiggerTheSecond");
        sll.add("NiggerTheThird");
        sll.add("NiggerTheLast");

        System.out.println("Count: " + sll.count());

        System.out.println("Current Elements");
        sll.printElements();

        sll.removeLast();

        System.out.println("Removed Nigger The Third");
        System.out.println("Count: " + sll.count());

        System.out.println("Current Elements");
        sll.printElements();

        sll.remove("NiggerTheLast");
        System.out.println("Removing Nigger The Last");

        System.out.println("Count: " + sll.count());

        System.out.println("Current Elements");
        sll.printElements();

        System.out.println("Removing Last");
        sll.removeLast();

        System.out.println("Current Elements");
        sll.printElements();
        System.out.println("Count: " + sll.count());
    }
}

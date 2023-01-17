/**
 * HashSetLP implements a hash set using linear probing.
 * Note: null is not allowed as an element in the set.
 */
public class HashSetLP<E> {
    // the hash table
    private E[] table;
    // the number of elements in the hash set
    private int size;
    // the special value used to mark an earlier occupied entry as free
    @SuppressWarnings("unchecked")
    private final E deleted = (E) new Object();

    /**
     * Create a new HashSetLP with the given table length.
     */
    public HashSetLP(int tableLength) {
        @SuppressWarnings("unchecked")
        E[] emptyTable = (E[]) new Object[tableLength];
        table = emptyTable;
        size = 0;
    }

    private int hash(E element) {
        int h = element.hashCode();
        if (h < 0) h = -h;
        h = h % table.length;
        return h;
    }

    /**
     * Return true, if element is in the set.
     */
    public boolean contains(E element) {
        if (size == 0){
            return false;
        }
        int hashed = hash(element);
        while(table[hashed] != null){
            if (table[hashed] == element){
                return true;
            }
        }
        return false;
    }

    /**
     * Add element to the set.
     * Returns true, if the element is added to the set.
     * Throw IllegalArgumentException, if element is null.
     */
    public boolean add(E element) {
        if (element == null){
            throw new IllegalArgumentException();
        }
        int hashed = hash(element);
        int ogHashed = hashed;
        int i = 0;
        while(table[hashed+i] != null && table[hashed+i] != deleted){
            i++;
            if(hashed + i >= table.length){
                hashed = 0;
                i = 0;
            }
            if (hashed + i == ogHashed){
                return false;
            }
        }
        table[hashed+i] = element;
        size++;
        return true;
    }

    /**
     * Remove element from the set.
     * Returns true, if the element is removed from the set.
     */
    public boolean remove(E element) {
        int hashed = hash(element);
        int ogHashed = hashed;
        int i = 0;
        while(table[hashed+i] != null){
            if (table[hashed+i] == element){
                table[hashed+i] = deleted;
                size--;
                return true;
            }
            i++;
            if(hashed + i == ogHashed){
                return false;
            }
        }
        return false;
    }

    /**
     * Return the number of elements in the set.
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int i = 0;
        while(i<table.length){
            if(table[i] != null && table[i] != deleted){
                sb.append(", ").append(table[i]);
            }
            i++;
        }
        sb.delete(1,3);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        HashSetLP<String> lp = new HashSetLP<>(10);

        System.out.println(lp.add("Pussy"));

        System.out.println(lp.add("Pussy"));

        System.out.println(lp.add("Pussy"));

        System.out.println(lp.add("Pussy"));

        System.out.println(lp.add("Pussy"));

        System.out.println(lp.add("Pussy"));

        System.out.println(lp.contains("Pussy"));

        System.out.println(lp.add("Pussy"));

        System.out.println(lp);

        System.out.println(lp.remove("Pussy"));

        System.out.println(lp.remove("Pussy"));

        System.out.println(lp);
    }
}

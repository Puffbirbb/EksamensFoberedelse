public class Domino {
    public static void main(String[] args) {
        System.out.println(f(500));
    }

    public static int f(int n){
        return n >= 3 ? f(n - 1)+f(n-2) : n;
    }
}

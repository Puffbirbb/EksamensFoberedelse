public class Euclid {
    public static void main(String[] args) {
        System.out.println(gcd(54, 888));
    }

    public static int gcd(int a, int b){
        if (b <= a && a % b == 0){
            return b;
        } else if (a < b){
            return gcd(b,a);
        } else {
            return gcd(b, a % b);
        }
    }
}

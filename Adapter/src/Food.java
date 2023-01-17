public class Food extends Item {

    Food(double netprice, String name) {
        super(netprice, name);
    }

    public double calcVAT(){
        return netprice * 0.05;
    }
}

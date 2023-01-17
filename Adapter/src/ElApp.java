public class ElApp extends Item {

    ElApp(double netprice, String name) {
        super(netprice, name);
    }

    public double calcVAT(){
        return getNetprice() * 0.3 < 3 ? 3 : getNetprice() * 0.3;
    }
}

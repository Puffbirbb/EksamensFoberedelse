public abstract class Item {
    double netprice;
    String name;

    Item(double netprice, String name){
        this.name = name;
        this.netprice = netprice;
    }

    public double getNetprice() {
        return netprice;
    }

    public void setNetprice(double netprice) {
        this.netprice = netprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calcVAT(){
        return 0;
    }
}

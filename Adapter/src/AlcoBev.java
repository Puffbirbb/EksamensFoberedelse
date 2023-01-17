public class AlcoBev {
    double theNetprice;
    String theDescription;

    public AlcoBev(String theDescription, double theNetprice){
        this.theDescription = theDescription;
        this.theNetprice = theNetprice;
    }

    public double getTheNetprice() {
        return theNetprice;
    }

    public String getTheDescription() {
        return theDescription;
    }

    public void setTheNetprice(double theNetprice) {
        this.theNetprice = theNetprice;
    }

    public void setTheDescription(String theDescription) {
        this.theDescription = theDescription;
    }

    public double getVat(){
        return theNetprice > 150 ? theNetprice * 1.2 : theNetprice * 0.8;
    }
}

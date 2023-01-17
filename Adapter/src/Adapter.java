public class Adapter extends Item {

    AlcoBev alcoBev;

    Adapter(double netprice, String name, AlcoBev alcoBev) {
        super(netprice, name);
        this.alcoBev = alcoBev;
    }

    @Override
    public double getNetprice() {
        return alcoBev.getTheNetprice();
    }

    @Override
    public void setNetprice(double netprice) {
        alcoBev.setTheNetprice(netprice);
    }

    @Override
    public String getName() {
        return alcoBev.getTheDescription();
    }

    @Override
    public void setName(String name) {
        alcoBev.setTheDescription(name);
    }

    @Override
    public double calcVAT() {
        return alcoBev.getVat();
    }
}

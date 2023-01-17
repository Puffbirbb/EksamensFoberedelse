import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item Coca_Cola = new Food(19.95,"Coca Cola");

        Item MSI_LAPTOP = new ElApp( 20199.95, "MSI LAPTOP");

        AlcoBev vodka = new AlcoBev("3L Grey Goose",369.95);
        Item vodkaAdapter = new Adapter(369.95,"3L Grey Goose", vodka);

        ArrayList<Item> items = new ArrayList<>(List.of(Coca_Cola,MSI_LAPTOP,vodkaAdapter));
        System.out.printf("%-14s | %-8s | %-8s | %s\n", "Navn", "Net Pris", "VAT", "Total");
        System.out.println("---------------------------------------------");
        for(Item e : items){
            System.out.printf("%-14s | %-8.2f | %-8.2f | %.2f\n", e.getName(), e.getNetprice(), e.calcVAT(), e.getNetprice() + e.calcVAT());
        }
    }
}

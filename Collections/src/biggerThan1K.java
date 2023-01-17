import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class biggerThan1K {
    public static void main(String[] args) {
        try {
            TreeMap ghSet = new TreeMap<>();
            int count = 0;
            File Gjoengehoevdingen = new File("C:\\Users\\gwion\\IdeaProjects\\EksamensFoberedelse\\Collections\\src\\Gjoengehoevdingen.txt");
            Scanner myReader = new Scanner(Gjoengehoevdingen);
            myReader.useDelimiter("[^\\wæøåÆØÅ]+");
            while (myReader.hasNext()){
                String data = myReader.next();
                ghSet.put(data, count);
                count++;
            }
            myReader.close();
            int limit = 0;
            int aktuel = 0;
            for(Object s : ghSet.keySet()){
                limit++;
                if (limit > 1000){
                    aktuel++;
                    System.out.println(s);
                }
            }
            System.out.println("Different Word Count: " + ghSet.size());
            System.out.println("Total Word Count: " + count);
            System.out.println("Printed Elements: " + aktuel);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

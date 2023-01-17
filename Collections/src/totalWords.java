import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class totalWords {
    public static void main(String[] args) {
        try {
            TreeSet ghSet = new TreeSet<>();
            int count = 0;
            File Gjoengehoevdingen = new File("C:\\Users\\gwion\\IdeaProjects\\EksamensFoberedelse\\Collections\\src\\Gjoengehoevdingen.txt");
            Scanner myReader = new Scanner(Gjoengehoevdingen);
            myReader.useDelimiter("[^\\wæøåÆØÅ]+");
            while (myReader.hasNext()){
                String data = myReader.next();
                ghSet.add(data);
                count++;
            }
            myReader.close();
            for(Object s : ghSet){
                System.out.println(s);
            }
            System.out.println("Different Word Count: " + ghSet.size());
            System.out.println("Total Word Count: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

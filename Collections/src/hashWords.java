import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class hashWords {
    public static void main(String[] args) {
        try {
            Map<Integer, HashSet<String>> ghSet = new LinkedHashMap<>();
            int count = 0;
            int uniqueCounter = 0;
            File Gjoengehoevdingen = new File("C:\\Users\\gwion\\IdeaProjects\\EksamensFoberedelse\\Collections\\src\\Gjoengehoevdingen.txt");
            Scanner myReader = new Scanner(Gjoengehoevdingen);
            myReader.useDelimiter("[^\\wæøåÆØÅ]+");
            while (myReader.hasNext()){
                count++;
                String data = myReader.next();
                if(!data.equals("") && !data.equals("-")){
                    int dataHash = data.hashCode();
                    if (!ghSet.containsKey(dataHash)){
                        HashSet<String> hashSet = new HashSet<>();
                        hashSet.add(data);
                        ghSet.put(dataHash, hashSet);
                        uniqueCounter++;
                    }
                    else {
                        ghSet.get(dataHash).add(data);
                    }
                }

            }
            myReader.close();
            for (Integer key : ghSet.keySet()){
                HashSet<String> value = ghSet.get(key);
                if (value.size() > 1){
                    System.out.println(key + ": " + value);
                }
            }
            System.out.println("Unique: " + uniqueCounter + " Total: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

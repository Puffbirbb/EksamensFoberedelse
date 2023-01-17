package Storage;

import Module.Person;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage uniqueInstance;
    private List<Person> names;

    private Storage(){
        names = new ArrayList<>();
    }

    public static Storage getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Storage();
        }
        return uniqueInstance;
    }

    public void addPerson(Person p){
        names.add(p);
    }
}

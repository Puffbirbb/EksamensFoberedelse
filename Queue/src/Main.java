public class Main {
    public static void main(String[] args) {
        Circle missionaires = new Circle();

        Person Bent = new Person("Bent");
        Person Karl = new Person("Karl");
        Person Peter = new Person("Peter");
        Person Laura = new Person("Laura");
        Person Julie = new Person("Julie");
        Person Sarah = new Person("Sarah");

        missionaires.addPerson(Bent);
        missionaires.addPerson(Karl);
        missionaires.addPerson(Peter);
        missionaires.addPerson(Laura);
        missionaires.addPerson(Julie);
        missionaires.addPerson(Sarah);

        System.out.println("The Survivors Initially");
        missionaires.printPersons();

        System.out.println();

        System.out.println(missionaires.removeFirst() + " Is Eaten First.");

        System.out.println();

        System.out.println(missionaires.removeNext(2) + " Is Eaten Second.");

        System.out.println();

        System.out.println(missionaires.removeNext(4) + " Is Eaten Third.");

        System.out.println();

        System.out.println(missionaires.removeNext(3) + " Is Eaten Fourth.");

        System.out.println();

        System.out.println(missionaires.removeNext(5) + " Is Eaten Fifth.");

        System.out.println();
        System.out.println("The Last Survivor Is");

        missionaires.printPersons();
    }
}

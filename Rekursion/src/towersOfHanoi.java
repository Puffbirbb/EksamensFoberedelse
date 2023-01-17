public class towersOfHanoi {
    static long moves = 0;

    public static void main(String[] args) {
        ToH(32);
        System.out.println("Moves Required: " + moves);
    }

    public static void ToH(int plates){
        if (plates == 0){
            return;
        }
        ToH(plates - 1);
        //System.out.println("Moving Disk: " + plates);
        ToH(plates - 1);
        moves++;
    }
}

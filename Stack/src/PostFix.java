public class PostFix {
    public static void main(String[] args) {
        System.out.println("Expected 10");
        System.out.println("Result = " + evaluate("12 2 5 + - 4 * 2 /"));
    }

    public static int evaluate(String input){
        LinkedStack<String> iev = new LinkedStack<>();
        String[] split = input.split(" ");
        int i = 0;
        int num1;
        int num2;
        while(i < split.length){
            if(split[i].matches("[0-9]*")){
                iev.push(split[i]);
            } else if(split[i].equals("+")){
                if(iev.size <= 1){
                    throw new RuntimeException();
                }
                num1 = Integer.parseInt(iev.pop());
                num2 = Integer.parseInt(iev.pop());
                int result = num1 + num2;
                iev.push("" + result);
            } else if(split[i].equals("-")){
                if(iev.size <= 1){
                    throw new RuntimeException();
                }
                num1 = Integer.parseInt(iev.pop());
                num2 = Integer.parseInt(iev.pop());
                int result = num2 - num1;
                iev.push("" + result);
            } else if(split[i].equals("*")){
                if(iev.size <= 1){
                    throw new RuntimeException();
                }
                num1 = Integer.parseInt(iev.pop());
                num2 = Integer.parseInt(iev.pop());
                int result = num2 * num1;
                iev.push("" + result);
            } else if(split[i].equals("/")){
                if(iev.size <= 1){
                    throw new RuntimeException();
                }
                num1 = Integer.parseInt(iev.pop());
                num2 = Integer.parseInt(iev.pop());
                int result = num2 / num1;
                iev.push("" + result);
            }
            i++;
        }
        return Integer.parseInt(iev.pop());
    }
}

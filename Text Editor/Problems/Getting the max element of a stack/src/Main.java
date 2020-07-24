import java.util.*;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> mainStack = new ArrayDeque<>();
        ArrayDeque<Integer> trackStack = new ArrayDeque<>();
        int nCommands = scanner.nextInt();
        int n = 0;
        for (int i = 0; i < nCommands; i++) {
            String line = scanner.next();
            switch (line) {
                case "pop" :
                    mainStack.pop();
                    trackStack.pop();
                    break;
                case "max" :
                    System.out.println(trackStack.peek());
                    break;
                case "push" :
                    n = scanner.nextInt();
                    mainStack.push(n);
                    if (trackStack.isEmpty() || n > trackStack.peek()) {
                        trackStack.push(n);
                    } else {
                        trackStack.push(trackStack.peek());
                    }
                    break;
                default :
                    System.out.println("Unknown input");
                    break;
            }
        }
    }
}
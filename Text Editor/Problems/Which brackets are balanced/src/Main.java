import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String openBrackets = "({[";

        Deque<String> stack = new ArrayDeque<>();

        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            String current = input.substring(i, i+1);
            if (openBrackets.contains(current)) {
                stack.push(current);
            } else {
                // closing bracket ){[
                // must match the last bracket entered
                String last = stack.peekFirst();
                boolean toAdd = true;
                if (")".equals(current) && "(".equals(last)) {
                    stack.pop();
                    toAdd = false;
                }
                if ("}".equals(current) && "{".equals(last)) {
                    stack.pop();
                    toAdd = false;
                }
                if ("]".equals(current) && "[".equals(last)) {
                    stack.pop();
                    toAdd = false;
                }
                if (toAdd) {
                    // if not matched then add to stack
                    stack.push(current);
                }
            }
        }

        System.out.println(stack.isEmpty() ? true : false);
    }
}

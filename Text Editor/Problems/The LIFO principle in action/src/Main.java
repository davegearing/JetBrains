import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Deque<Integer> q = new ArrayDeque<>();

        Scanner s = new Scanner(System.in);
        int elementCount = s.nextInt();
        while (s.hasNextInt()) {
            q.offer(s.nextInt());
        }
        while (q.peekLast() != null) {
            System.out.println(q.pollLast());
        }
    }
}
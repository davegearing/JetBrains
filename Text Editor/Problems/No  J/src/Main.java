import java.sql.Array;
import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        // write your code here
        List<String> list = Arrays.asList(array.clone());

        ListIterator<String> iterator = list.listIterator();

        // go to end of list
        while (iterator.hasNext()) {
            iterator.next();
        }
        // print entry starting with J
        // but drop the J
        while (iterator.hasPrevious()) {
            String current = iterator.previous();
            String cur1 = current.substring(0,1);
            if ("J".equals(cur1)) {
                System.out.println(current.substring(1,current.length()));
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}
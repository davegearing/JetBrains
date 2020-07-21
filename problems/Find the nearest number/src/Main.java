import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list1 = readArrayList(scanner);
        int searchNumber = scanner.nextInt();

        ArrayList<Integer> list2 = new ArrayList<>();
        for (int integer : list1) {
            int intList2 = Math.abs(integer - searchNumber);
            list2.add(intList2);
        }
        int min = Collections.min(list2);
        for (int i = list2.size() - 1; i >= 0; i--) {
            if (!list2.get(i).equals(min)) {
                list1.remove(i);
            }
        }
        Collections.sort(list1);
        for (int integer : list1) {
            System.out.print(integer + " ");
        }
    }

    /* Do not modify this method */
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
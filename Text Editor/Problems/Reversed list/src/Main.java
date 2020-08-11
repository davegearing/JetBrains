import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static <T> List<T> createReversedListByIterator(ListIterator<T> iterator) {
        List<T> list = new ArrayList<>();

        // write your code here
        // go to end of list
        while (iterator.hasNext())  {
            iterator.next();
        }

        // from the end of the list add the values
        // to the new list
        while (iterator.hasPrevious()) {
            list.add(iterator.previous());
        }

        return list;
    }

    /* Do not change the code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        createReversedListByIterator(list.listIterator())
                .forEach(e -> System.out.print(e + " "));
    }
}
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);

        int numberOfWords = s.nextInt();
        Set dictionary = new HashSet<>();
        for (int i = 0; i < numberOfWords ; i++) {
            dictionary.add(s.next().toLowerCase());
        }

        String numberOfLines = s.next();

        //Set document = new HashSet();
        Set errors = new HashSet();
        while (s.hasNext()) {
            String word = s.next().toLowerCase();
            if (!dictionary.contains(word)) {
                errors.add(word);
            }
        }

        errors.forEach(System.out::println);
    }

}
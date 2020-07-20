import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        String regex = "password" + "[:]?\\s*\\w+";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        boolean isFound = false;
        while (matcher.find()) {
            isFound = true;
            String[] words = matcher.group().replace(":", " ").split(" ");
            System.out.println(words[words.length - 1]);
        }
        if (!isFound) {
            System.out.println("No passwords found.");
        }
    }
}
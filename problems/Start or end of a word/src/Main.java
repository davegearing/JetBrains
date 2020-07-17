import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        // write your code here
        // \\b word boundary
        Pattern pattern = Pattern.compile("\\b" + part, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        Pattern pattern1 = Pattern.compile(part + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(line);

        System.out.println(!matcher.find() && !matcher1.find() ? "NO" : "YES");
    }
}
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        String str = "[a-z]*program[a-z]*";
        Pattern pattern = Pattern.compile(str,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            MatchResult result = matcher.toMatchResult();
            System.out.println(matcher.start() + " " + matcher.group());
        }
    }
}
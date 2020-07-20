//import javafx.css.Match;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        // write your code here
        // my code String regex = "\\b" + "[0-9]*" + "\\b";
        String regex = "[\\d]{10,}";    // solution code
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringWithNumbers);

        while (matcher.find()) {
            MatchResult result = matcher.toMatchResult();
            int len = matcher.end() - matcher.start();
            if (len >= 10) {
                System.out.println(matcher.group() + ":" + len);
            }
        }
    }
}
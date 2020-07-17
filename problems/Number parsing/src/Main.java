import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // test 1: 123 YES [+-]?[1-9]+[0-9]*
        // test 2: 0123 NO [+-]?[1-9]+[0-9]*
        // test 3: -56.0 YES [+-]?[1-9]+[0-9]*[.,][0]
        // test 4: 0,05 YES [+-]?[0][.,][0-9]*[1-9]+
        // test 5: -23.230 NO [+-]?[1-9]+[0-9]*[.,][0-9]*[1-9]+
        // test 6 : +12376352189432535347623423443417,36817231873134176345178234234234234 [+-]?[1-9]+[0-9]*[.,][0-9]*[1-9]+
        // test 7 : 0.0 0,0 YES [0][.,]][0]
        // test 8 ,000000001 YES [+-]?[.,][0-9]*[1-9]+

        // solution answer  String regex = "^[+-]?(0|[1-9]\\d*)([.,](0|\\d*[1-9]))?$";
        String regex = "[+-]?[1-9]+[0-9]*|[+-]?[1-9]+[0-9]*[.,][0]|[+-]?[0][.,][0-9]*[1-9]+|[+-]?[1-9]+[0-9]*[.,][0-9]*[1-9]+|[0][.,][0]|[+-]?[.,][0-9]*[1-9]+";
        String number = scanner.nextLine();

        System.out.println(number.matches(regex) ? "YES" : "NO");
    }
}
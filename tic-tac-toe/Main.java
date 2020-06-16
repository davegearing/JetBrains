package Tic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String symbols = scanner.next();

        String[][] field = new String[3][3];
        int i = 0;
        int xCount = 0;
        int oCount = 0;
        int emptyCount = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                String thisChar = String.valueOf(symbols.charAt(i));
                if (thisChar.equals("X")) {
                    xCount++;
                } else {
                    if (thisChar.equals("O")) {
                        oCount++;
                    } else {
                        emptyCount++;
                    }
                }
                field[j][k] = thisChar;
                i++;
            }
        }

        System.out.println("---------");
        System.out.println("| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |");
        System.out.println("---------");
        System.out.println("");

        //System.out.println("xcount=" +xCount);
        //System.out.println("ocount=" +oCount);
        //System.out.println("emptycount=" +emptyCount);

        boolean misCount = false;
        if (xCount - oCount > 1 || oCount - xCount > 1) {
            misCount = true;
        }

        String row1 = field[0][0] + field[0][1] + field[0][2];
        String row2 = field[1][0] + field[1][1] + field[1][2];
        String row3 = field[2][0] + field[2][1] + field[2][2];

        String col1 = field[0][0] + field[1][0] + field[2][0];
        String col2 = field[0][1] + field[1][1] + field[2][1];
        String col3 = field[0][2] + field[1][2] + field[2][2];

        String diag1 = field[0][0] + field[1][1] + field[2][2];
        String diag2 = field[2][0] + field[1][1] + field[0][2];

        boolean xWins = false;
        boolean oWins = false;
        if (row1.equals("XXX") || row2.equals("XXX") || row3.equals("XXX") || col1.equals("XXX") || col2.equals("XXX") || col3.equals("XXX") || diag1.equals("XXX") || diag2.equals("XXX")) {
            xWins = true;
        }
        if (row1.equals("OOO") || row2.equals("OOO") || row3.equals("OOO") || col1.equals("OOO") || col2.equals("OOO") || col3.equals("OOO") || diag1.equals("OOO") || diag2.equals("OOO")) {
            oWins = true;
        }

        if (xWins == false && oWins == false && emptyCount > 0 && !misCount) {
            System.out.println("Game not finished");
        } else {
            if (xWins == false && oWins == false && emptyCount == 0) {
                System.out.println("Draw");
            } else {
                if (xWins && oWins) {
                    System.out.println("Impossible");
                } else {
                    if (misCount) {
                        System.out.println("Impossible");
                    } else {
                        if (xWins) {
                            System.out.println("X wins");
                        } else {
                            System.out.println("O wins");
                        }
                    }
                }
            }
        }
    }
}
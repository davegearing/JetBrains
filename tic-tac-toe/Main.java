package Tic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //String symbols = scanner.nextLine();
        String symbols = "_________";   //empty field

        String[][] field = new String[3][3];

        String[][] newField = fillField(symbols, field);
        displayField(newField);

        String theWinner = "";
        for (int gameCount = 1 ;; gameCount++) {

            int[] counts = analyseField(newField);
            boolean misCount = false;
            int xCount = counts[0];
            int oCount = counts[1];
            int emptyCount = counts[2];
            if (xCount - oCount > 1 || oCount - xCount > 1) {
                misCount = true;
            }

            String winner = "";
            winner = checkWinner(newField, emptyCount, misCount);
            if (!winner.equals("")) {
                break;
            }

            String userMove = getMove(newField, scanner);
            int col = Integer.parseInt(userMove.substring(0, 1));
            int row = Integer.parseInt(userMove.substring(2, 3));
            if (gameCount % 2 == 0) {
                newField[3 - row][col - 1] = "O";
            } else {
                newField[3 - row][col - 1] = "X";
            }

            displayField(newField);
        }
    }

    public static String getMove(String[][] field, Scanner scanner) {
        boolean validMove;
        do {
            validMove = true;
            String userMove = scanner.nextLine();
            String col = userMove.substring(0,1);
            String row = "";
            if (userMove.length() >=3) {
                row = userMove.substring(2,3);
            }
            if (col.equals("1") || col.equals("2") || col.equals("3")) {
            } else {
                validMove = false;
            }
            if (row.equals("1") || row.equals("2") || row.equals("3")) {
            } else {
                validMove = false;
            }
            if (validMove) {
                int col1 = Integer.parseInt(userMove.substring(0,1));
                int row1 = Integer.parseInt(userMove.substring(2,3));
                String currentCell = field[3-row1][col1-1];
                if (currentCell.equals("X") || currentCell.equals("O")) {
                    validMove = false;
                }
            }
            if (!validMove) {
                System.out.println("not a valid move, try again");
            } else {
                return userMove;
            }
        } while (!validMove);

        return "";
    }

    public static void displayField(String[][] field) {
        System.out.println("---------");
        System.out.println("| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |");
        System.out.println("---------");
        //System.out.println("");
    }

    public static String[][] fillField(String symbols, String[][] field) {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                String thisChar = String.valueOf(symbols.charAt(i));
                field[j][k] = thisChar;
                i++;
            }
        }

        return field;
    }

    public static int[] analyseField(String[][] field) {
        int[] counts = new int[3];
        int xCount = 0;
        int oCount = 0;
        int emptyCount = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                String thisChar = field[j][k];
                if (thisChar.equals("X")) {
                    xCount++;
                } else {
                    if (thisChar.equals("O")) {
                        oCount++;
                    } else {
                        emptyCount++;
                    }
                }
            }
        }

        counts[0] = xCount;
        counts[1] = oCount;
        counts[2] = emptyCount;

        return counts;
    }

    public static String checkWinner(String[][] field, int emptyCount, boolean misCount) {
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

        if (!xWins && !oWins && emptyCount > 0 && !misCount) {
            //System.out.println("Game not finished");
        } else {
            if (!xWins && !oWins && emptyCount == 0) {
                System.out.println("Draw");
                return "Z";
            } else {
                if (xWins && oWins) {
                    System.out.println("Impossible");
                } else {
                    if (misCount) {
                        System.out.println("Impossible");
                    } else {
                        if (xWins) {
                            System.out.println("X wins");
                            return "X";
                        } else {
                            System.out.println("O wins");
                            return "O";
                        }
                    }
                }
            }
        }
        return "";
    }
}
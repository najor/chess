package main.java;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.chess.Chess;
import main.java.exception.ChessException;

public class Main {

    private static Pattern INPUT_PATTERN = Pattern.compile("(\\w+)\\s(\\w+)");

    public static void main(String[] args) {

        printMovingExample();

	    Chess game = Chess.createGame();
        game.printBoard();

        Scanner scanner = new Scanner(System.in);
        String input;
        String turn = "white";

        do {
            System.out.print(turn + ": ");
            input = scanner.nextLine();

            Matcher m = INPUT_PATTERN.matcher(input);

            if (m.matches()) {
                try {
                    game.move(turn, m.group(1), m.group(2));

                    if (turn.equals("white")) {
                        turn = "black";
                    } else {
                        turn = "white";
                    }
                } catch (ChessException ex) {
                    System.err.println(ex.getMessage());
                }
                game.printBoard();
            }
        } while (!"exit".equals(input));
    }

    private static void printMovingExample() {
        System.out.println("Example of moving:");
        System.out.println(" > white: C2 C4");
        System.out.println(" > black: C7 C6");
        System.out.println(" > exit // exit the program");
    }
}

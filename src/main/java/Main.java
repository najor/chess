package main.java;

import main.java.chess.Chess;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    Chess game = Chess.createGame();

        game.printBoard();

        Scanner scanner = new Scanner(System.in);
        String input;
        String turn = "white";

        while (true) {
            System.out.print(turn + ": ");
            input = scanner.nextLine();

            Pattern p = Pattern.compile("(\\w+)\\s(\\w+)");
            Matcher m = p.matcher(input);

            if (m.matches()) {
                try {
                    game.move(turn, m.group(1), m.group(2));

                    if (turn.equals("white")) {
                        turn = "black";
                    } else {
                        turn = "white";
                    }
                } catch (NotMoveAllowedExecption notMoveAllowedExecption) {
                    System.err.println("Move no allowed.");
                }
                game.printBoard();
            }


        }
    }
}

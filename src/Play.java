import java.util.Scanner;

public class Play {

    private static Labyrinth lab;

    public static void main(String[] args) {

        // Enter code for taking user input but for it's default as "Player 1" and "Player 2"
        lab = new Labyrinth();

        Scanner reader = new Scanner(System.in);

        while (true) {
            printBoard();
            System.out.print("Player 1 move piece from: ");
            String player1from = reader.next();
            System.out.print("\nPlayer 1 move piece " + player1from + " to: ");
            String player1to = reader.next();
            if (player1from.equals("quit") || player1from.equals("q")) {
                break;
            }
            System.out.println("The player 1 input is " + player1from + " " + player1to);



        }
        reader.close();

    }

    public static void printBoard() {
        String output;


        for (int i = 0; i < 33; i++) {
            if (i == 32) {
                System.out.println("-");
            } else {
                System.out.print("-");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (lab.getGraph().getBoard()[i][j].getPiece().getName().equals("0")) {
                    output = " ";
                } else {
                    output = lab.getGraph().getBoard()[i][j].getPiece().getName();
                }

                System.out.print("| " + output + " ");
                if (j == 7) {
                    System.out.println("|");
                }
            }

            for (int k = 0; k < 33; k++) {
                if (k == 32) {
                    System.out.println("-");
                } else {
                    System.out.print("-");
                }
            }

        }
    }

}

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Objects;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PlayTTT extends JFrame {
    static final long serialVersionUID = 0;
    private final char COMPUTER = 'o';
    private final char HUMAN = 'x';
    private final char BLOCKED = 'b';

    private JButton[][] gameDisplay;/* Game board */
    private BlockedTicTacToe t;
    // private int board_size; /* Size of game board */
    private int max_level; /*
     * Maximum level of the game tree that will be
     * explored
     */
    private TTTDictionary configurations;
    private int numBlockedPositions; /* Number of blocked positions */
    private int[] blockedPositions; /* Set of blocked positions */

    private Labyrinth lab;

    private ClickHandler handler;

    /*
     * Constructor. Creates a panel to represent the game board and destroys the
     * panel when its window is closed.
     */
    public PlayTTT(int size, int to_win, int depth, int num, int[] b) {
        Container c = getContentPane();
        c.setLayout(new GridLayout(size, size));
        gameDisplay = new JButton[size][size];
        Icon emptyWhiteSquare = new ImageIcon("rsz_white.jpg");
        Icon emptyBlackSquare = new ImageIcon("rsz_black.jpg");
        Icon blackpawnonwhite = new ImageIcon("blackpawnonwhite.jpg");
        Icon whitepawnonwhite = new ImageIcon("whitepawnonwhite.jpg");
        Icon blackpawnonblack = new ImageIcon("blackpawnonblack.jpg");
        Icon whitepawnonblack = new ImageIcon("whitepawnonblack.jpg");

        handler = new ClickHandler(size);

        lab = new Labyrinth();


        Square[][] board = lab.getGraph().getBoard();
        /* Board is represented as a grid of clickable buttons */
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if ((i + j) % 2 == 0) {
                    gameDisplay[i][j] = new JButton("", emptyWhiteSquare);
                    if (board[i][j].getPiece().getName().equals("P") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackpawnonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("P") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whitepawnonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("B") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackbishoponwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("B") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whitebishoponwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("N") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackknightonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("N") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whiteknightonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("R") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackrookonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("R") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whiterookonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("Q") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackqueenonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("Q") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whitequeenonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("K") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackkingonwhite.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("K") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whitekingonwhite.jpg"));
                    }
                } else {
                    gameDisplay[i][j] = new JButton("", emptyBlackSquare);
                    if (board[i][j].getPiece().getName().equals("P") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackpawnonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("P") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whitepawnonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("B") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackbishoponblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("B") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whitebishoponblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("N") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackknightonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("N") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whiteknightonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("R") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackrookonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("R") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whiterookonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("Q") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackqueenonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("Q") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whitequeenonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("K") && (board[i][j].getPiece().getColour() == 0)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("blackkingonblack.jpg"));
                    } else if (board[i][j].getPiece().getName().equals("K") && (board[i][j].getPiece().getColour() == 1)) {
                        gameDisplay[i][j] = new JButton("", new ImageIcon("whitekingonblack.jpg"));
                    }
                }
                gameDisplay[i][j].setEnabled(true);
                add(gameDisplay[i][j]);
                gameDisplay[i][j].addActionListener(handler);
            }


        System.out.println("For loops end");
        // board_size = size;
        max_level = depth;
        numBlockedPositions = num;
        blockedPositions = b;

        t = new BlockedTicTacToe(size, to_win, depth); /* User code needed to play */

        for (int i = 0; i < numBlockedPositions; ++i) {
            int row = blockedPositions[i] / size;
            int col = blockedPositions[i] % size;
            gameDisplay[row][col].setIcon(new ImageIcon("blocked1.gif"));
            gameDisplay[row][col].paint(gameDisplay[row][col].getGraphics());

            t.storePlay(row, col, BLOCKED);
        }

        System.out.println("End of the PlayTTT constructor");
    }

    /*
     * To run the program type: java PlayTTT size to_win, where size is the size
     * of the board and to_win is the number of symbols in line needed to win
     * the game.
     */
    public static void main(String[] args) {
        int size = 0, adjacent_to_win = 0, depth = 0;
        int numBlocked;
        int[] blocked;

        /* Check that the number of arguments is the correct one */
        if (args.length < 3) {
            System.out.println("Usage: java PlayTTT board-size symbols-inline-to-win depth blocked-positions");
            System.exit(0);
        }

        try {
            /* Size of the game board */
            size = Integer.parseInt(args[0]);

            /*
             * Number of positions marked by the same player in the same row,
             * column, or diagonal, required to win
             */
            adjacent_to_win = Integer.parseInt(args[1]);
            depth = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid program argument");
            System.exit(0);
        }

        /* Read the set of blocked positions and stored in array "blocked" */
        numBlocked = args.length - 3;
        blocked = new int[numBlocked];
        for (int i = 0; i < numBlocked; ++i) {
            blocked[i] = Integer.parseInt(args[3 + i]) - 1;
            if ((blocked[i] < 0) || (blocked[i] >= size * size)) {
                System.out.println("Invalid board position " + blocked[i]);
                System.exit(0);
            }
        }

        /* Create the game board and start the game */
        JFrame f = new PlayTTT(size, adjacent_to_win, depth, numBlocked, blocked);

        f.setSize(size * 100, size * 100);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });


//        if (Math.random() > 0.5)
//            ((PlayTTT)f).handler.displayComputerPlay();

        System.out.println("End of the main PlayTTT function");
    }


    /*
     * Panel to represent the game board. It contains methods for detecting the
     * position selected by the human player.
     */

    private class ClickHandler implements ActionListener {
        private int board_size;
        private boolean game_ended = false;
        private int count = 0;
        private int position1x;
        private int position1y;
        private int position2x;
        private int position2y;
        private int[] position1;
        private int[] position2;

        /* Constructor. Save board size in instance variable */
        public ClickHandler(int size) {
            System.out.println("Inside the click handler constructor");
            board_size = size;
            position1 = new int[2];
            position2 = new int[2];
        }

        /*
         * When the user has selected a play, this method is invoked to process
         * the selected play
         */
        public void actionPerformed(ActionEvent event) {

            System.out.println("Inside the actionPerformed method");
            if (event.getSource() instanceof JButton) { /*
             * Some position of the
             * board was selected
             */
                int row = -1, col = -1;

                if (game_ended)
                    System.exit(0);
                /* Find out which position was selected by the player */
                for (int i = 0; i < board_size; i++) {
                    for (int j = 0; j < board_size; j++)
                        if (event.getSource() == gameDisplay[i][j]) {
                            row = i;
                            col = j;
                            break;
                        }
                    if (row != -1)
                        break;
                }

                Rules rules = new Rules(lab.getGraph().getBoard()[row][col]);
                rules.canGo(lab.getGraph().getBoard()[row][col]);

                int[] possibilityX = rules.getPossibilityX();
                int[] possibilityY = rules.getPossibilityY();

                if (count == 0) {
//                    Rules rules = new Rules(lab.getGraph().getBoard()[row][col]);
//                    rules.canGo(lab.getGraph().getBoard()[row][col]);

                    position1x = row;
                    position1y = col;
                    position1[0] = position1x;
                    position1[1] = position1y;
                    count++;
                    System.out.println("Starting click is (" + row + ", " + col + ")");
//                    int[] possibilityX = rules.getPossibilityX();
//                    int[] possibilityY = rules.getPossibilityY();

                    System.out.println("possibilityX[0] is " + possibilityX[0]);
                    System.out.println("possibilityY[0] is " + possibilityY[0]);

                    System.out.println("Possible coordinates for this piece are :\n");

                    int index = 0;

                    while ((possibilityX[index] != -1) && (possibilityY[index] != -1)) {

                        if (lab.getGraph().getBoard()[possibilityY[index]][possibilityX[index]].getPiece().getName().equals("0")) {
                            if (lab.getGraph().getBoard()[possibilityY[index]][possibilityX[index]].getColour() == 0) {
                                gameDisplay[possibilityY[index]][possibilityX[index]].setIcon(new ImageIcon("emptyblackwithborder.jpg"));
                                gameDisplay[possibilityY[index]][possibilityX[index]].paint(gameDisplay[possibilityY[index]][possibilityX[index]].getGraphics());
                            } else if (lab.getGraph().getBoard()[possibilityY[index]][possibilityX[index]].getColour() == 1) {
                                gameDisplay[possibilityY[index]][possibilityX[index]].setIcon(new ImageIcon("emptywhitewithborder.jpg"));
                                gameDisplay[possibilityY[index]][possibilityX[index]].paint(gameDisplay[possibilityY[index]][possibilityX[index]].getGraphics());
                            }

                        }

                        System.out.println("\t(" + possibilityX[index] + ", " + possibilityY[index] + ") " + lab.getGraph().getBoard()[possibilityY[index]][possibilityX[index]].getPiece().getColour());
                        index++;
                    }

//
//                    for (int i = 0; i < possibilityX.length; i++) {
//                        System.out.println("\t(" + possibilityX[i] + ", " + possibilityY[i] + ")");
//                    }
                } else if (count == 1) {
//                    Rules rules = new Rules(lab.getGraph().getBoard()[row][col]);
//                    rules.canGo(lab.getGraph().getBoard()[row][col]);

                    position2x = row;
                    position2y = col;
                    position2[0] = position2x;
                    position2[1] = position2y;
                    count = 0;
                    System.out.println("Ending click is (" + row + ", " + col + ")");
//                    int[] possibilityX = rules.getPossibilityX();
//                    int[] possibilityY = rules.getPossibilityY();

//                    System.out.println("possibilityX[0] is " + possibilityX[0]);
//                    System.out.println("possibilityY[0] is " + possibilityY[0]);
//
//                    System.out.println("Possible coordinates for this piece are :\n");

                    int index = 0;


                    while ((possibilityX[index] != -1) && (possibilityY[index] != -1)) {

                        if (lab.getGraph().getBoard()[possibilityY[index]][possibilityX[index]].getPiece().getName().equals("0")) {
                            if (lab.getGraph().getBoard()[possibilityY[index]][possibilityX[index]].getColour() == 0) {
                                gameDisplay[possibilityY[index]][possibilityX[index]].setIcon(new ImageIcon("rsz_black.jpg"));
                                gameDisplay[possibilityY[index]][possibilityX[index]].paint(gameDisplay[possibilityY[index]][possibilityX[index]].getGraphics());
                            } else if (lab.getGraph().getBoard()[possibilityY[index]][possibilityX[index]].getColour() == 1) {
                                gameDisplay[possibilityY[index]][possibilityX[index]].setIcon(new ImageIcon("rsz_white.jpg"));
                                gameDisplay[possibilityY[index]][possibilityX[index]].paint(gameDisplay[possibilityY[index]][possibilityX[index]].getGraphics());
                            }

                        }

                        System.out.println("\t(" + possibilityX[index] + ", " + possibilityY[index] + ") " + lab.getGraph().getBoard()[possibilityY[index]][possibilityX[index]].getPiece().getColour());
                        index++;
                    }
                }

//                System.out.println("Coordinate is (" + row + ", " + col + ")");

//                if (t.squareIsEmpty(row, col)) {
//                    /* Valid play, mark it on the board */
//                    gameDisplay[row][col].setIcon(new ImageIcon("human.gif"));
//                    gameDisplay[row][col].paint(gameDisplay[row][col].getGraphics());
//
//                    t.storePlay(row, col, HUMAN);
//                    if (t.wins(HUMAN))
//                        endGame("Human wins");
//                    else {
//                        if (t.isDraw())
//                            endGame("Game is a draw");
//                        else
//                            displayComputerPlay();
//                    }
//                } else
//                    System.out.println("Invalid play");

            }
        }

        private void displayComputerPlay() {
            PosPlay pos;

            pos = computerPlay(COMPUTER, -1, 4, 0);
            t.storePlay(pos.getRow(), pos.getCol(), COMPUTER);
            gameDisplay[pos.getRow()][pos.getCol()].setIcon(new ImageIcon("computer.gif"));
            if (t.wins(COMPUTER))
                endGame("Computer wins");
            else if (t.isDraw())
                endGame("Game is a draw");
        }

        /* Explore the game tree and choose the best move for the computer */
        private PosPlay computerPlay(char symbol, int highest_score, int lowest_score, int level) {

            char opponent; // Opponent's symbol
            PosPlay reply; // Opponent's best reply

            int bestRow = -1;
            int bestColumn = -1; // Position of best play

            int value;
            int lookupVal;

            if (level == 0) /* Create new hash table */
                configurations = t.createDictionary();

            if (symbol == COMPUTER) {
                opponent = HUMAN;
                value = -1;
            } else {
                opponent = COMPUTER;
                value = 4;
            }

            // Scan entries of the game board in random order
            int row, column;
            row = (int)(Math.random() * board_size);

            for (int r = 0; r < board_size; r++) {
                column = (int)(Math.random() * board_size);
                for (int c = 0; c < board_size; c++) {
                    if (t.squareIsEmpty(row, column)) { // Empty position
                        t.storePlay(row, column, symbol); // Store next play
                        if (t.wins(symbol) || t.isDraw() || (level >= max_level))
                            // Game ending situation or max number of levels
                            // reached
                            reply = new PosPlay(t.evalBoard(), row, column);
                        else {
                            lookupVal = t.repeatedConfig(configurations);
                            if (lookupVal != -1)
                                reply = new PosPlay(lookupVal, row, column);
                            else {
                                reply = computerPlay(opponent, highest_score, lowest_score, level + 1);
                                t.insertConfig(configurations, reply.getScore(), 0);
                            }
                        }
                        t.storePlay(row, column, ' ');

                        if ((symbol == COMPUTER && reply.getScore() > value)
                                || (symbol == HUMAN && reply.getScore() < value)) {
                            bestRow = row;
                            bestColumn = column;
                            value = reply.getScore();

                            /* Alpha/beta cut */
                            if (symbol == COMPUTER && value > highest_score)
                                highest_score = value;
                            else if (symbol == HUMAN && value < lowest_score)
                                lowest_score = value;

                            if (highest_score >= lowest_score)
                                return new PosPlay(value, bestRow, bestColumn);
                        }

                    }
                    column = (column + 1) % board_size;
                }
                row = (row + 1) % board_size;
            }
            return new PosPlay(value, bestRow, bestColumn);
        }

        /* Prompt the user for a key to terminate the game */
        private void endGame(String mssg) {
            System.out.println(mssg);
            System.out.println("");
            System.out.println("Click on board to terminate game");
            game_ended = true;
        }

    }
}

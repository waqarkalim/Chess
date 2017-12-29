public class Labyrinth {

    private Player player1;
    private Player player2;

    private Graph graph;
    private Square[][] board;


    public Labyrinth() {

        graph = new Graph();
        board = graph.getBoard();

        board[0][0].setPiece(new Piece("R", 0, 0, 0));
        board[0][1].setPiece(new Piece("N", 1, 0, 0));
        board[0][2].setPiece(new Piece("B", 2, 0, 0));
        board[0][3].setPiece(new Piece("Q", 3, 0, 0));
        board[0][4].setPiece(new Piece("K", 4, 0, 0));
        board[0][5].setPiece(new Piece("B", 5, 0, 0));
        board[0][6].setPiece(new Piece("N", 6, 0, 0));
        board[0][7].setPiece(new Piece("R", 7, 0, 0));

        for (int i = 0; i < 8; i++) {
            board[1][i].setPiece(new Piece("P", i, 1, 0));
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 6; j++) {
                board[j][i].setPiece(new Piece("0", i, j, 2));
            }
        }

        for (int i = 0; i < 8; i++) {
            board[6][i].setPiece(new Piece("P", i, 6, 1));
        }

        board[7][0].setPiece(new Piece("R", 0, 7, 1));
        board[7][1].setPiece(new Piece("N", 1, 7, 1));
        board[7][2].setPiece(new Piece("B", 2, 7, 1));
        board[7][3].setPiece(new Piece("Q", 3, 7, 1));
        board[7][4].setPiece(new Piece("K", 4, 7, 1));
        board[7][5].setPiece(new Piece("B", 5, 7, 1));
        board[7][6].setPiece(new Piece("N", 6, 7, 1));
        board[7][7].setPiece(new Piece("R", 7, 7, 1));

//        this.player1 = new Player("Player 1", 0);
//        this.player2 = new Player("Player 2", 1);

    }

    public Player getPlayer1(){
        return this.player1;
    }

    public Player getPlayer2(){
        return this.player2;
    }

    public Graph getGraph() {
        return graph;
    }
}

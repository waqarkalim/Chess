public class Graph {

    private Piece[] pieces;
    private Square[][] board;

    public Graph() {

        pieces = new Piece[16];
        board = new Square[8][8];


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = new Square(1, null);
                } else {
                    board[i][j] = new Square(0, null);
                }
            }
        }


    }

    public Piece getPiece(int i, int j) {
        return board[i][j].getPiece();
    }

    public Square[][] getBoard() {
        return board;
    }
}

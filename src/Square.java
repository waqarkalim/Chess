public class Square {

    private int colour; // 0 = black, 1 = white
    private Piece piece;

    public Square(int colour, Piece piece) {
        this.colour = colour;
        this.piece = piece;
    }

    public int getColour() {
        return this.colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}

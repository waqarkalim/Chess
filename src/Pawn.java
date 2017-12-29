public class Pawn {

    private String name;
    private int row;
    private int col;
    private Square position;

    public Pawn(int row, int col, Square position) {
        this.name = "P";
        this.row = row;
        this.col = col;
        this.position = position;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Square canGo() {
        return null;
    }


}

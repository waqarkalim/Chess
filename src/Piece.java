public class Piece {

    private int positionx;
    private int positiony;
    private String name;
    private boolean mark;
    private int colour; // 0 = black, 1 = white

    public Piece(String name, int positionx, int positiony, int colour) {
        this.positionx = positionx;
        this.positiony = positiony;
        this.name = name;
        this.colour = colour;
    }

    public boolean getMark() {
        return this.mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionx() {
        return this.positionx;
    }

    public int getPositiony() {
        return this.positiony;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}

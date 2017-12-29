public class Rules {

    private Square square;
    private int[] possibilityX;
    private int[] possibilityY;

    public Rules(Square square) {
        this.square = square;
        this.possibilityX = new int[14];
        this.possibilityY = new int[14];

        for (int i = 0; i < 14; i++) {
            this.possibilityX[i] = -1;
            this.possibilityY[i] = -1;
        }
    }

    public Piece getPiece() {
        return square.getPiece();
    }

    public Square getSquare() {
        return square;
    }

    public void canGo(Square square) {
        System.out.println("This square is of piece " + square.getPiece().getName() + " and color is " + square.getPiece().getColour());
        if (square.getPiece().getName().equals("P")) {
            Pawn(square.getPiece().getColour());
        } else if (square.getPiece().getName().equals("N")) {
            Knight(square.getPiece().getColour());
        }
    }
    public void Pawn(int colour) {
        if (colour == 0) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Starting iteration no. " + i);
                possibilityX[i] = square.getPiece().getPositionx();
                possibilityY[i] = square.getPiece().getPositiony() + i + 1;
            }
        } else if (colour == 1) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Starting iteration no. " + i);
                possibilityX[i] = square.getPiece().getPositionx();
                possibilityY[i] = square.getPiece().getPositiony() - i - 1;
            }
        }
    }

    public void Knight(int colour) {
        int[] possibleKnightX = new int[8];
        int[] possibleKnightY = new int[8];

        int x = square.getPiece().getPositionx();
        int y = square.getPiece().getPositiony();

        possibleKnightX[0] = x + 2;
        possibleKnightY[0] = y + 1;

        possibleKnightX[1] = x + 2;
        possibleKnightY[1] = y - 1;

        possibleKnightX[2] = x + 1;
        possibleKnightY[2] = y + 2;

        possibleKnightX[3] = x + 1;
        possibleKnightY[3] = y - 2;

        possibleKnightX[4] = x - 1;
        possibleKnightY[4] = y + 2;

        possibleKnightX[5] = x - 1;
        possibleKnightY[5] = y - 2;

        possibleKnightX[6] = x - 2;
        possibleKnightY[6] = y + 1;

        possibleKnightX[7] = x - 2;
        possibleKnightY[7] = y - 1;

        for (int i = 0; i < 8; i++) {
            for (int j = i; j < 8; j++) {
                if (((possibleKnightX[j] < 0) || (possibleKnightX[j] > 7)) || ((possibleKnightY[j] < 0) || (possibleKnightY[j] > 7))) {
                    continue;
                }
                possibilityX[i] = possibleKnightX[j];
                possibilityY[i] = possibleKnightY[j];
                break;
            }
        }
    }

    public void Bishop(int colour) {

        int[] possibleBishopX = int[14];
        int[] possibleBishopY = int[14];

        int x = square.getPiece().getPositionx();
        int y = square.getPiece().getPositiony();

        
    }

    public int[] getPossibilityX() {
        return possibilityX;
    }

    public int[] getPossibilityY() {
        return possibilityY;
    }
}

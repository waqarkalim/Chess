public class Player {

    private String name;
    private int colour; // 0 = black, 1 = white
    private Graph graph;


    public Player(String name, int colour) {

        graph = new Graph();
        this.name = name;
        this.colour = colour;

        for (int i = 0; i < 8; i++) {
            graph.getPiece(i, 0).setName("P");
        }
        graph.getPiece(0, 1).setName("R");
        graph.getPiece(1, 1).setName("N");
        graph.getPiece(2, 1).setName("B");

        if (this.colour == 0) {
            graph.getPiece(3, 1).setName("K");
            graph.getPiece(4, 1).setName("Q");
        } else {
            graph.getPiece(3, 1).setName("Q");
            graph.getPiece(4, 1).setName("K");
        }

        graph.getPiece(5,1).setName("B");
        graph.getPiece(6, 1).setName("N");
        graph.getPiece(7, 1).setName("R");

    }

    public String getName() {
        return this.name;
    }
    public Graph getGraph() {
        return graph;
    }
    public int getColour() {
        return this.colour;
    }
}

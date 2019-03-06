public class Board {

    private int[][] theBoard;

    public void initBoard() {
        this.theBoard = new int[][]{
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 2, 0, 2, 0, 2, 0},
                {0, 2, 0, 2, 0, 2, 0, 2},
                {2, 0, 2, 0, 2, 0, 2, 0},
        };
    }

    public void printBoard() {
        System.out.println("   0 1 2 3 4 5 6 7");
        System.out.println(" + --------------- +");
        for (int i = 0; i <= 7; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j <= 7; j++) {
                if (theBoard[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(theBoard[i][j] + " ");
                }
            }
            System.out.print("|" + i);
            System.out.println();
        }
        System.out.println(" + --------------- +");
        System.out.println("   0 1 2 3 4 5 6 7");
    }


    public void manipulate(Piece p) {
        // Insert stuff
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.initBoard();
        b.printBoard();
    }
}

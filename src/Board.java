

public class Board {

    private Piece[][] theBoard;

    //Defines the board and insert the Piece objects in the array.
    public void initBoard(Player p1, Player p2) {
        this.theBoard = new Piece[8][8];
        C[] P_1_INIT = {new C(1,0), new C(3,0), new C(5,0), new C(7,0),
            new C(0,1), new C(2,1), new C(4,1), new C(6,1),
            new C(1,2), new C(3,2), new C(5,2), new C(7,2)};
        C[] P_2_INIT = {new C(0,5), new C(2,5), new C(4,5), new C(6,5),
            new C(1,6), new C(3,6), new C(5,6), new C(7,6),
            new C(0,7), new C(2,7), new C(4,7), new C(6,7)};

        for (int i = 0; i < 12; i++) {
            int COL = P_1_INIT[i].getFirst();
            int ROW = P_1_INIT[i].getSecond();
            int COL2 = P_2_INIT[i].getFirst();
            int ROW2 = P_2_INIT[i].getSecond();
            theBoard[ROW][COL] = new Piece(COL, ROW, p1);
            theBoard[ROW2][COL2] = new Piece(COL, ROW, p2);
        }
    }

    public void printBoard() {
        System.out.println("\n   0 1 2 3 4 5 6 7");
        System.out.println(" + --------------- +");
        for (int i = 0; i <= 7; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j <= 7; j++) {
                if (theBoard[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(theBoard[i][j].getOwner().getPlayerNumber() + " ");
                }
            }
            System.out.print("|" + i);
            System.out.println();
        }
        System.out.println(" + --------------- +");
        System.out.println("   0 1 2 3 4 5 6 7");
    }

    public Piece getPiece(int row, int col) {
        return theBoard[row][col];
    }

    public void removePiece(Piece p) {
        theBoard[p.getyCoord()][p.getxCoord()] = null;
    }

    // Checks if a spot if free of any other piece.
    public boolean isNewPosAvailable(C newPos, Piece p) {
        int newCol = newPos.getFirst();
        int newRow = newPos.getSecond();
        int curCol = p.getxCoord();
        int curRow = p.getyCoord();
        if (theBoard[newRow][newCol] == null) {
            return true;
        } else if (curCol == newCol && curRow == newCol) {
            System.err.println("Your piece already occupies this position.");
            return false;
        } else {
            System.err.println("This position is occupied by another piece.");
            return false;
        }
        // Make some checking for other Pieces in that position
    }

    public void manipulate(Piece p) {
        // Actually move the piece depending of the properties if Piece
    }
}

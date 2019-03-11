import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class NotAPieceException extends Exception {
    public NotAPieceException(String msg) {
        super(msg);
    }
}

public class Board {

    private final Integer[] LegalMovesArray = {0, 1, 2, 3, 4, 5, 6, 7};
    private final List<Integer> LegalMoves = Arrays.asList(LegalMovesArray);
    private Piece[][] theBoard;

    public List<Integer> getLegalMoves() {
        return LegalMoves;
    }

    public Piece[][] getBoard() {
        return theBoard;
    }

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
            theBoard[ROW2][COL2] = new Piece(COL2, ROW2, p2);
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

    public Piece getContent(C pos) {
        return theBoard[pos.getSecond()][pos.getFirst()];
    }

    public Piece getPiece(C pos) throws NotAPieceException {
        if (theBoard[pos.getSecond()][pos.getFirst()] == null) {
            throw new NotAPieceException("Selected position does not contain a piece");
        }
        return theBoard[pos.getSecond()][pos.getFirst()];
    }

    public void removePiece(Piece p) {
        theBoard[p.getyCoord()][p.getxCoord()] = null;
    }

    public void removePiece(C pos) {
        theBoard[pos.getSecond()][pos.getFirst()] = null;
    }

    public void setNewPiece(Piece p) {
        theBoard[p.getyCoord()][p.getxCoord()] = p;
    }

    // Checks if a spot if free of any other piece.
    public boolean isNewPosAvailable(C newPos, Piece p, Board board) throws IllegalMoveException {
        int newCol = newPos.getFirst();
        int newRow = newPos.getSecond();
        int curCol = p.getxCoord();
        int curRow = p.getyCoord();
        if (board.getBoard()[newRow][newCol] == null) {
            return true;
        } else if (curCol == newCol && curRow == newCol) {
            throw new IllegalMoveException("Your piece already occupies this spot.");
        } else {
            throw new IllegalMoveException("This position is occupied by another piece.");
        }
    }

    // Checks if some chosen coordinate is within the board
    public boolean isWithinBounds(C pos, Board board) throws IllegalMoveException {
        Integer R = pos.getSecond();
        Integer C = pos.getFirst();
        Integer[] input = {R, C};
        Collection moves = Arrays.asList(input);
        if (!board.getLegalMoves().containsAll(moves)) {
            throw new IllegalMoveException("This position is out of bounds");
        }
        return (true);
    }
}

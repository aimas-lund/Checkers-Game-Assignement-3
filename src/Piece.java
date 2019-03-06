import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Piece {

    static final Integer[] LegalMovesArray = {0, 1, 2, 3, 4, 5, 6, 7};
    static final List<Integer> LegalMoves = Arrays.asList(LegalMovesArray);

    private int col;
    private int row;
    private Player owner;

    Piece(int x, int y, Player p) {
        col = x;
        row = y;
        owner = p;
    }

    public int getyCoord() {
        return row;
    }

    public void setyCoord(int row) {
        this.row = row;
    }

    public int getxCoord() {
        return col;
    }

    public void setxCoord(int col) {
        this.col = col;
    }

    public Player getOwner() {
        return owner;
    }

    // Checks if some chosen coordinate is within the board
    public boolean isWithinBounds(C pos) {
        Integer R = pos.getSecond();
        Integer C = pos.getFirst();
        Integer[] input = {R, C};
        Collection moves = Arrays.asList(input);
        return (LegalMoves.containsAll(moves));
    }

    public boolean regularMove(C curPos, C newPos) {
        int curCol = curPos.getFirst();
        int curRow = curPos.getSecond();
        int newCol = newPos.getFirst();
        int newRow = newPos.getSecond();

        if (owner.getPlayerNumber() == 1) {
            // Make normal move requirements for Player 1
            return true;
        } else {
            // Make normal move requirements for Player 2
            return true;
        }
    }

    public boolean attackingMove(C curPos, C newPos) {
        int curCol = curPos.getFirst();
        int curRow = curPos.getSecond();
        int newCol = newPos.getFirst();
        int newRow = newPos.getSecond();

        if (owner.getPlayerNumber() == 1) {
            // Make attack move requirements for Player 1
            return true;
        } else {
            // Make attack moves requirements for Player 2
            return true;
        }
    }
}
//    public static void main(String[] args) {
//        Player pl = new Player(Players.P_1);
//        Piece pi = new Piece(0,1, pl);
//        C sel = pl.selectCoord();
//        System.out.println(pi.isWithinBounds(sel.getFirst(), sel.getSecond()));
//    }


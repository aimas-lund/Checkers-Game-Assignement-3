import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Piece {

    static final Integer[] LegalMovesArray = {0,1,2,3,4,5,6,7};
    static final Collection movesCollection = Arrays.asList(LegalMovesArray);
    static final List<Integer> LegalMoves = Arrays.asList(LegalMovesArray);

    private int col;
    private int row;
    private int owner;

    Piece(int x, int y, Player p) {
        col = x;
        row = y;
        owner = p.getPlayerNumber();
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

    public int getOwner() {
        return owner;
    }

    // Checks if some chosen coordinate is within the board
    public boolean isWithinBounds(int row, int col) {
        Integer R = row;
        Integer C = col;
        Integer[] input = {R, C};
        Collection moves = Arrays.asList(input);
        return (LegalMoves.containsAll(moves));
    }

//    public static void main(String[] args) {
//        Player pl = new Player(Players.P_1);
//        Piece pi = new Piece(0,1, pl);
//        C sel = pl.selectCoord();
//        System.out.println(pi.isWithinBounds(sel.getFirst(), sel.getSecond()));
//    }

}

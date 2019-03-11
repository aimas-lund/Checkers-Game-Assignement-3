import java.util.Arrays;
import java.util.Collection;

public class Piece {

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
}
//    public static void main(String[] args) {
//        Player pl = new Player(Players.P_1);
//        Piece pi = new Piece(0,1, pl);
//        C sel = pl.selectCoord();
//        System.out.println(pi.isWithinBounds(sel.getFirst(), sel.getSecond()));
//    }


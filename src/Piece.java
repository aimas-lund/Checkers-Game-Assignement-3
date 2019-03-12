
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

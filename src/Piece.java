public class Piece {

    private int xCoord;
    private int yCoord;
    private int owner;

    Piece(int x, int y, Player p) {
        xCoord = x;
        yCoord = y;
        owner = p.getPlayerNumber();
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getOwner() {
        return owner;
    }
}

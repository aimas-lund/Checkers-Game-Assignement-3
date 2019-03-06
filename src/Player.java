enum Players {
    P_1(1), P_2(2);

    private int number;

    Players(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class Player {

    private Players pn;

    public Player(Players pn) {
        this.pn = pn;
    }

    public int getPlayerNumber() {
        return pn.getNumber();
    }

    public void printPlayerNumber() {
        System.out.println("Player " + getPlayerNumber());
    }
}

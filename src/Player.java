import java.util.Scanner;

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
    private boolean turn;

    public Player(Players pn) {
        this.pn = pn;
        this.turn = false;
    }

    public int getPlayerNumber() {
        return pn.getNumber();
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isTurn() {
        return this.turn;
    }

    public C selectCoord() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nChoose x-coordinate:");
        int col = input.nextInt();
        System.out.println("\nChoose y-coordinate:");
        int row = input.nextInt();

        return new C(col, row);
    }
}

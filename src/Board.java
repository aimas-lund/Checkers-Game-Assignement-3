class C {
    private final int first;
    private final int second;

    public C(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}

public class Board {

    private Piece[][] theBoard;

    public void initBoard(Player p1, Player p2) {
        this.theBoard = new Piece[8][8];
        C[] P_1_INIT = {new C(1,0), new C(3,0), new C(5,0), new C(7,0),
            new C(0,1), new C(2,1), new C(4,1), new C(6,1),
            new C(1,2), new C(3,2), new C(5,2), new C(7,2)};
        C[] P_2_INIT = {new C(0,5), new C(2,5), new C(4,5), new C(6,5),
            new C(1,6), new C(3,6), new C(5,6), new C(7,6),
            new C(0,7), new C(2,7), new C(4,7), new C(6,7)};

        for (int i = 0; i < 12; i++) {
            int X = P_1_INIT[i].getFirst();
            int Y = P_1_INIT[i].getSecond();
            theBoard[Y][X] = new Piece(X, Y, p1);
        }
        for (int i = 0; i < 12; i++) {
            int X = P_2_INIT[i].getFirst();
            int Y = P_2_INIT[i].getSecond();
            theBoard[Y][X] = new Piece(X, Y, p2);
        }

    }

    public void printBoard() {
        System.out.println("   0 1 2 3 4 5 6 7");
        System.out.println(" + --------------- +");
        for (int i = 0; i <= 7; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j <= 7; j++) {
                if (theBoard[i][j] == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(theBoard[i][j].getOwner() + " ");
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
}

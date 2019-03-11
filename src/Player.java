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

    public boolean regularMove(C curPos, C newPos, Piece piece, Board board) throws IllegalMoveException {
        int displacementRow = newPos.getSecond() - curPos.getSecond();
        boolean verifyX = Math.abs(newPos.getFirst() - curPos.getFirst()) == 1;

        if (getPlayerNumber() == 1) {
            // Normal move requirements for Player 1
            if ((verifyX) && (displacementRow == -1)) {
                return board.isWithinBounds(newPos, board) && board.isNewPosAvailable(newPos, piece, board);
            } else throw new IllegalMoveException("Given move is not a legal 'regular' move");
        } else {
            // Normal move requirements for Player 2
            if ((verifyX) && (displacementRow == 1)) {
                return board.isWithinBounds(newPos, board) && board.isNewPosAvailable(newPos, piece, board);
            } else throw new IllegalMoveException("Given move is not a legal 'regular' move");
        }
    }

    public boolean attackingMove(C curPos, C newPos, Piece piece, Board board) throws IllegalMoveException {
        int displacementRow = newPos.getSecond() - curPos.getSecond();
        boolean verifyX = Math.abs(newPos.getFirst() - curPos.getFirst()) == 2;

        if (getPlayerNumber() == 1) {
            // Make attack move requirements for Player 1
            return true;
        } else {
            // Make attack moves requirements for Player 2
            return true;
        }
    }

}

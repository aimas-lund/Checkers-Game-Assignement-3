import java.util.*;

public class CheckersGame {

    //Takes some user input and returns it as coordinates C (tuple)
    public C selectCoord() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nChoose x-coordinate:");
        int col = input.nextInt();
        System.out.println("\nChoose y-coordinate:");
        int row = input.nextInt();

        return new C(col, row);
    }

    public void switchTurn(Player p1, Player p2) {
        System.out.println("\nSwitching Turn!");
        if (p1.isTurn()) {
            p1.setTurn(false);
            p2.setTurn(true);
            System.out.println("Turn of: Player " + p2.getPlayerNumber());
        } else {
            p1.setTurn(true);
            p2.setTurn(false);
            System.out.println("Turn of: Player " + p1.getPlayerNumber());
        }
    }

    public static void main(String[] args) {
        CheckersGame game = new CheckersGame();
        System.out.println("Welcome to Object-oriented Checkers!");

        System.out.println("Initializing game...\n");
        Player player1 = new Player(Players.P_1);
        Player player2 = new Player(Players.P_2);
        Board board = new Board();

        board.initBoard(player1, player2);
        board.printBoard();
        player1.setTurn(true);
        game.switchTurn(player1, player2);
        //System.out.println(game.selectCoord().getSecond());
        board.removePiece(board.getPiece(1,0));
        board.printBoard();

    }
}

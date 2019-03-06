public class CheckersGame {

    public static void main(String[] args) {
        System.out.println("Welcome to Object-oriented Checkers!");

        System.out.println("Initializing game...\n");
        Player player1 = new Player(Players.P_1);
        Player player2 = new Player(Players.P_2);
        Board board = new Board();

        board.initBoard(player1, player2);
        board.printBoard();
    }
}

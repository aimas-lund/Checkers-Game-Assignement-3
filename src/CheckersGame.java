public class CheckersGame {

    public static void main(String[] args) {
        System.out.println("Welcome to Object-oriented Checkers!");
        System.out.println("Initializing game...\n");
        Board board = new Board();
        board.initBoard();
        board.printBoard();
    }
}

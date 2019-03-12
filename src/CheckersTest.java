import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class CheckersTest {

    //Pieces Test
    @Test
    public void getOwnerNumber1() {
        Player player = new Player(Players.P_1);
        Piece piece = new Piece(1,3, player);

        int owner = piece.getOwner().getPlayerNumber();
        assertTrue(owner == 1);
    }

    @Test
    public void getOwnerNumber2() {
        Player player = new Player(Players.P_2);
        Piece piece = new Piece(3,3, player);

        int owner = piece.getOwner().getPlayerNumber();
        assertTrue(owner == 2);
    }

    //C tuple test
    @Test
    public void tupleTest1() {
        C c = new C(1,2);
        assertTrue(c.getFirst() == 1);
    }

    @Test
    public void tupleTest2() {
        C c = new C(1,2);
        assertTrue(c.getSecond() == 2);
    }


    //Board Tests
    @Test
    public void initBoardTest1() {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(board.getBoard()[1][4] != null);
    }

    @Test
    public void initBoardTest2() {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(board.getBoard()[0][0] == null);
    }

    //Now we know there is nothing in (0,0)...
    @Test(expected = NotAPieceException.class)
    public void getPieceTest1() throws NotAPieceException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        Piece piece = board.getPiece(new C(0, 0));
    }

    @Test
    public void getPieceTest2() throws NotAPieceException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(board.getPiece(new C(0, 1)) instanceof Piece);
    }

    @Test(expected = NotAPieceException.class)
    public void removePieceTest1() throws NotAPieceException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        Piece piece = board.getPiece(new C(0, 1));
        board.removePiece(piece);
        board.getPiece(new C(0,1));
    }

    // Spot 2, 3 should be occupied by the piece itself
    @Test (expected = IllegalMoveException.class)
    public void isNewPositionAvailableTest1() throws NotAPieceException, IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        Piece piece = board.getPiece(new C(3, 2));
        C c = new C(3,2);
        board.isNewPosAvailable(c,piece,board);
    }

    // The spot 1, 2 should be occupied by another piece
    @Test (expected = IllegalMoveException.class)
    public void isNewPositionAvailableTest2() throws NotAPieceException, IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        Piece piece = board.getPiece(new C(3, 2));
        board.isNewPosAvailable(new C(2,1), piece, board);
    }

    // The spot 3, 4 should not be occupied
    @Test
    public void isNewPositionAvailableTest3() throws NotAPieceException, IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        Piece piece = board.getPiece(new C(3, 2));
        assertTrue(board.isNewPosAvailable(new C(4,3), piece, board));
    }

    // 8 is not within the bounds of the Board
    @Test (expected = IllegalMoveException.class)
    public void isWithinBoundsTest1() throws IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(board.isWithinBounds(new C(8,3), board));
    }

    @Test (expected = IllegalMoveException.class)
    public void isWithinBoundsTest2() throws IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(board.isWithinBounds(new C(3,8), board));
    }

    @Test (expected = IllegalMoveException.class)
    public void isWithinBoundsTest3() throws IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(board.isWithinBounds(new C(3,-1), board));
    }

    // -1 is not within the bounds of the Board
    @Test (expected = IllegalMoveException.class)
    public void isWithinBoundsTest4() throws IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(board.isWithinBounds(new C(-1,3), board));
    }
    // 0 and 7 are both within the bounds of the Board
    @Test
    public void isWithinBoundsTest5() throws IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(board.isWithinBounds(new C(0,7), board));
    }

    //Player Tests
    @Test
    public void regularMoveTest1() throws NotAPieceException, IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        assertTrue(p1.regularMove(new C(4,3), board.getPiece(new C(3,2)), board));
    }

    //Before the next test makes sense, we have to run this one first...
    @Test
    public void preRegularMoveTest2() throws NotAPieceException, IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        C c = new C(5,4);
        Piece piece = board.getPiece(new C(3,2));
        assertTrue(board.isNewPosAvailable(c, piece, board));
    }

    @Test (expected = IllegalMoveException.class)
    public void regularMoveTest2() throws NotAPieceException, IllegalMoveException {
        Board board = new Board();
        Player p1 = new Player(Players.P_1);
        Player p2 = new Player(Players.P_2);
        board.initBoard(p1,p2);
        C c = new C(5,4);
        Piece piece = board.getPiece(new C(3,2));
        board.isNewPosAvailable(c, piece, board);
        p1.regularMove(c, piece, board); //The move is not a "regular move" anymore
    }

}

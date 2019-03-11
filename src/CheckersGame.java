import java.util.InputMismatchException;

public class CheckersGame {

    //Takes some user input and returns it as coordinates C (tuple)
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

    public void makeAPlay(Board board, Player player) throws IllegalMoveException, NotAPieceException {
        C firstChoice = null;
        C secondChoice = null;
        Piece piece;
        int displacementCol;
        int displacementRow;
        boolean nonlegitimatePlay = true;
        boolean isIncorrectPieceCheck = true;

        while (nonlegitimatePlay) {
            // First, choose a piece belonging to you.
            while (isIncorrectPieceCheck) {
                System.out.println("Choose your piece, Player " + player.getPlayerNumber() + ".");
                try { // Chosen to catch exception here, given player is free to choose any integer.
                    firstChoice = player.selectCoord();
                } catch (BoardOutOfBoundsException e) {
                    System.err.println(e.getMessage());
                    continue;
                } catch (InputMismatchException e) {
                    System.err.println("Please only use integers as input");
                    continue;
                }
                Piece content = board.getContent(firstChoice);
                isIncorrectPieceCheck = (content == null) || (player != content.getOwner());
                if (isIncorrectPieceCheck) {
                    System.err.println("This coordinate does not contain a piece belonging to you.");
                }
            }

            piece = board.getPiece(firstChoice);
            System.out.println(piece.getxCoord() + "  " + piece.getyCoord());

            // Second, choose a destination for the piece.
            while (nonlegitimatePlay) {
                System.out.println("Choose the destination of your piece, Player " + player.getPlayerNumber() + ".");
                try { // Chosen to catch exception here, given player is free to choose any integer.
                    secondChoice = player.selectCoord();
                } catch (BoardOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                        continue;
                } catch (InputMismatchException e) {
                    System.err.println("Please only use integers as input");
                    continue;
                }
                if (board.getContent(secondChoice) != null) {
                    System.err.println("Space already occupied");
                    continue;
                }

                displacementCol = firstChoice.getFirst() - secondChoice.getFirst();
                displacementRow = firstChoice.getSecond() - secondChoice.getSecond();

                if (player.getPlayerNumber() == 1) {
                    if (Math.abs(displacementCol) == 1 && displacementRow == -1) {
                        if (player.regularMove(secondChoice, piece, board)) {
                            board.removePiece(piece);
                            piece.setxCoord(secondChoice.getFirst());
                            piece.setyCoord(secondChoice.getSecond());
                            board.setNewPiece(piece);
                            nonlegitimatePlay = false;
                        }
                    } else if (Math.abs(displacementCol) == 2 && displacementRow == -2) {
                        if (player.attackingMove(secondChoice, piece, board)) {
                            board.removePiece(piece);
                            C enemyPiecePos = new C(secondChoice.getFirst() + (displacementCol / 2),
                                    secondChoice.getSecond() + (displacementRow / 2));
                            board.removePiece(enemyPiecePos);
                            piece.setxCoord(secondChoice.getFirst());
                            piece.setyCoord(secondChoice.getSecond());
                            board.setNewPiece(piece);
                            nonlegitimatePlay = false;
                        }
                    } else {
                        System.err.println("Cannot go here");
                    }

                } else {
                    if (Math.abs(displacementCol) == 1 && displacementRow == 1) {
                        if (player.regularMove(secondChoice, piece, board)) {
                            board.removePiece(piece);
                            piece.setxCoord(secondChoice.getFirst());
                            piece.setyCoord(secondChoice.getSecond());
                            board.setNewPiece(piece);
                            nonlegitimatePlay = false;
                        }
                    } else if (Math.abs(displacementCol) == 2 && displacementRow == 2) {
                        if (player.attackingMove(secondChoice, piece, board)) {
                            board.removePiece(piece);
                            C enemyPiecePos = new C(secondChoice.getFirst() + (displacementCol / 2),
                                    secondChoice.getSecond() + (displacementRow / 2));
                            board.removePiece(enemyPiecePos);
                            piece.setxCoord(secondChoice.getFirst());
                            piece.setyCoord(secondChoice.getSecond());
                            board.setNewPiece(piece);
                            nonlegitimatePlay = false;
                        }
                    } else {
                        System.err.println("Cannot go here");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IllegalMoveException, NotAPieceException {
        CheckersGame game = new CheckersGame();
        System.out.println("Welcome to Object-oriented Checkers!");

        System.out.println("Initializing game...");
        Player player1 = new Player(Players.P_1);
        Player player2 = new Player(Players.P_2);
        Board board = new Board();
        board.initBoard(player1, player2);

        System.out.println("Ready to play! 3... 2... 1... GO!");
        player1.setTurn(true);
        while (true) {
            board.printBoard();
            if (player1.isTurn()) {
                game.makeAPlay(board, player1);
            } else {
                game.makeAPlay(board, player2);
            }
            game.switchTurn(player1, player2);
        }
    }
}

package ss.week4.tictactoe;

import ss.utils.TextIO;

/**
 * Class for maintaining the Tic Tac Toe game.
 * Lab assignment Module 2
 * @author Theo Ruys en Arend Rensink
 */
public class Game {
    public static final int NUMBER_PLAYERS = 2;

    /**
     * The board.
     * @invariant board is never null
     */
    private Board board;

    /**
     * The 2 players of the game.
     * @invariant the length of the array equals NUMBER_PLAYERS
     * @invariant all array items are never null
     */
    private Player[] players;

    /**
     * Index of the current player.
     * @invariant the index is always between 0 and NUMBER_PLAYERS
     */
    private int current;

    // -- Constructors -----------------------------------------------

    /**
     * Creates a new Game object.
     * @requires s0 and s1 to be non-null
     * @param s0 the first player
     * @param s1 the second player
     */
    public Game(Player s0, Player s1) {
        board = new Board();
        players = new Player[NUMBER_PLAYERS];
        players[0] = s0;
        players[1] = s1;
        current = 0;
    }

    // -- Commands ---------------------------------------------------

    /**
     * Starts the Tic Tac Toe game. <br>
     * Asks after each ended game if the user want to continue. Continues until
     * the user does not want to play anymore.
     */
    public void start() {
        boolean continueGame = true;
        while (continueGame) {
            reset();
            play();
            System.out.println("\n> Play another time? (y/n)?");
            continueGame = TextIO.getBoolean();
        }
    }

    /**
     * Resets the game. <br>
     * The board is emptied and player[0] becomes the current player.
     */
    private void reset() {
        current = 0;
        board.reset();
    }

    /**
     * Plays the Tic Tac Toe game. <br>
     * First the (still empty) board is shown. Then the game is played
     * until it is over. Players can make a move one after the other. 
     * After each move, the changed game situation is printed.
     */
    private void play() {
        boolean gameRunning = true; // Flag for game loop
        current = 1; // Set the initial move to player 1

        update(); // Show the empty board 

        while(gameRunning) { // Game loop

            System.out.println("Make your move " + (current == 1 ? "player 1" : "player 2")); // Conditionally indicates respective player to move

            int move = TextIO.getInt(); // Reads move 

            if (current == 1) { // If player 1 move

                if (board.isField(move) && board.isEmptyField(move)) { // If the move player 1 made is within the field and is also on an empty space

                    board.setField(move, players[current-1].getMark()); // Makes the player 1 move
                    
                    current = 2; // Sets the next move to player 2

                } else { // If move is bad (either off board or on a space in field which already has a mark)
                    System.out.println("Bad move. Try again."); 
                }
                
            } else if (current == 2) { // If player 2 move
                
                if (board.isField(move) && board.isEmptyField(move)) {  // If the move player 2 made is within the field and is also on an empty space
                    
                    board.setField(move, players[current-1].getMark()); // Set player 2 move
                    
                    current = 1; // Set next move to player 1

                } else { // Bad move
                    System.out.println("Bad move. Try again.");
                }
            }

            update(); // Updates the board after every move 

            if (board.isFull() || board.hasWinner()) { // Checks that the game isnt over 
                gameRunning = false;
            }
        }

        printResult();
    }

    /**
     * Prints the game situation.
     */
    private void update() {
        System.out.println("\ncurrent game situation: \n\n" + board.toString()
                + "\n");
    }

    /**
     * Prints the result of the last game. <br>
     * @requires the game to be over
     */
    private void printResult() {
        if (board.hasWinner()) {
            Player winner = board.isWinner(players[0].getMark()) ? players[0]
                    : players[1];
            System.out.println("Player " + winner.getName() + " ("
                    + winner.getMark().toString() + ") has won!");
        } else {
            System.out.println("Draw. There is no winner!");
        }
    }
}

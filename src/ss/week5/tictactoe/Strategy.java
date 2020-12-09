package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public interface Strategy {

    // Returns the name of the strategy
    public String getName();

    // Returns a next legal move, given the board for the player with mark
    public int determineMove(Board board, Mark mark);
}

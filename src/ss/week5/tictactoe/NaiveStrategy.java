package ss.week5.tictactoe;

import java.util.ArrayList;
import java.util.List;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class NaiveStrategy implements Strategy {
    
    @Override
    public String getName() {
        return "Naive";
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        List<Integer> emptyFieldIndices = new ArrayList<Integer>();  

        for (int i : Board.DIM_INDICES) {
            if (board.isEmptyField(i)) {
                emptyFieldIndices.add(i);
            }
        }

        return emptyFieldIndices.get((int) Math.random()* (emptyFieldIndices.size()-1));
    }
}

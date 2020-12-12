package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class ComputerPlayer extends Player {
    private Strategy strategy;

    public ComputerPlayer (Mark mark, Strategy strategy) {
        super(strategy.getName()+"-computer-"+mark.name(), mark);
        this.strategy = strategy;
    }

    public ComputerPlayer (Mark mark) {
        super("naive-computer-"+mark.name(), mark);
        this.strategy = new NaiveStrategy();
    }

    @Override
    public int determineMove(Board board) {
        return strategy.determineMove(board, mark);
    }


    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
package ss.week5.tictactoe;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class SmartStrategy implements Strategy {

    // Method to check if the computer has a chance at a 
    // direct win in the next move. 
    /**
     * 
     * @param board
     * @param mark
     * @return -1 if there is not move resulting in direct win or the index of the field which wil yield direct win
     */
    public int isDirectWin(Board board, Mark mark) {
        for (int i : Board.DIM_INDICES) { // Iterates over indices of a field
                
            if (board.isEmptyField(i)) { // If the field is empty
                board.setField(i, mark); // Make a move for that field as the computer
                if (board.isWinner(mark)){ // If the move is a winner 
                    return i;
                } 
            }

        }

        return -1;
    }

    public int isDirectLoss(Board board, Mark mark) {
        for (int i : Board.DIM_INDICES) {

            if (board.isEmptyField(i)) {
                board.setField(i, mark.other());
                if (board.isWinner(mark.other())) {
                    return i;
                }
            }
        }
        
        return -1;
    }

    public int firstEmpty(Board board) {
        for (int i : Board.DIM_INDICES) {
            if (board.isEmptyField(i)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int determineMove(Board board, Mark mark) {
        
        if (board.isEmptyField(1, 1)) { // If middle field is empty
            return board.index(1, 1);
        } else { // Case for checking if there is a move that results in a direct win for either computer or human
            

        
            Board boardCopy = board.deepCopy(); 
            int directWin = isDirectWin(boardCopy, mark);// Checks if there is a move which will result in a direct wictory for computer
            if (directWin != -1) {
                return directWin;
            }

            boardCopy = board.deepCopy();
            int directLoss = isDirectLoss(boardCopy, mark); // Checks if there is a move which will result in a direct wictory for the human player
            if (directLoss != -1) {
                return directLoss;
            }
         }

        return firstEmpty(board);
    }

    @Override
    public String getName() {
        return "Smart";
    }
}

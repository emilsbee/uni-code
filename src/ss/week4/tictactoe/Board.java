package ss.week4.tictactoe;

import java.util.Arrays;

// import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/**
 * Board for the Tic Tac Toe game. Module 2 lab assignment.
 *
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Board {
    public static final int DIM = 3;
    public static final int[] DIM_INDICES = new int[]{0,1,2,3,4,5,6,7,8};
    public static final int[] DIAGONAL_1 = new int[]{0,4,8};
    public static final int[] DIAGONAL_2 = new int[]{2,4,6};
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
        " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";

    /**
     * The DIM by DIM fields of the Tic Tac Toe board. See NUMBERING for the
     * coding of the fields.
     * @invariant there are always DIM*DIM fields
     * @invariant all fields are either Mark.EMPTY, Mark.XX or Mark.OO
     */
    private Mark[] fields;

    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty board.
     * @ensures all fields are EMPTY
     */
    public Board() {
    	fields = new Mark[Board.DIM*Board.DIM]; // Creates new board in the size of DIM*DIM
        Arrays.fill(fields, Mark.EMPTY);  // Fills the board array with empty Mark
    }

    /**
     * Creates a deep copy of this field.
     * @ensures the result is a new object, so not this object
     * @ensures the values of all fields of the copy match the ones of this Board
     */
    public Board deepCopy() {
        Board boardCopy = new Board();
        for (int i = 0; i < fields.length; i++) {
            boardCopy.setField(i, fields[i]);
        }
        return boardCopy;
    }


    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @requires row to be between 0 and DIM
     * @requires col to be between 0 and DIM
     * @return the index belonging to the (row,col)-field
     */
    public  int index(int row, int col) {
        return Board.DIM_INDICES[(row*Board.DIM)+col];
    }

    /**
     * Returns true if index is a valid index of a field on the board.
     * @ensures a positive result when the index is between 0 and DIM*DIM
     * @return true if 0 <= index < DIM*DIM
     */
    public boolean isField(int index) {
        return index >= 0 && index <= (Board.DIM*Board.DIM)-1;
    }

    /**
     * Returns true of the (row,col) pair refers to a valid field on the board.
     * @ensures true when both row and col are within the board's bounds
     * @return true if 0 <= row < DIM && 0 <= col < DIM
     */
    public boolean isField(int row, int col) {
        // Basically checks that the row and column are from 1 to Board.DIM
        return row+1 <= Board.DIM && row+1 >= 1 && col+1 <= Board.DIM && col+1 >= 1;
    }
    
    /**
     * Returns the content of the field i.
     * @requires i to be a valid field
     * @ensures the result to be either EMPTY, XX or OO
     * @param i the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    public Mark getField(int i) {
        return fields[i];
    }

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     * @requires (row, col) to be a valid field
     * @ensures the result to be either EMPTY, XX or OO
     * @param row the row of the field
     * @param col the column of the field
     * @return the mark on the field
     */
    public Mark getField(int row, int col) {
        return fields[index(row, col)];
    }

    /**
     * Returns true if the field i is empty.
     * @requires i to be a valid field index
     * @ensures true when the Mark at index i is EMPTY
     * @param i the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    public boolean isEmptyField(int i) {
        return fields[i].equals(Mark.EMPTY);
    }

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     * @requires (row, col) to be a valid field
     * @ensures true when the Mark at (row, col) is EMPTY
     * @param row the row of the field
     * @param col the column of the field
     * @return true if the field is empty
     */
    public boolean isEmptyField(int row, int col) {
        return fields[index(row, col)].equals(Mark.EMPTY);
    }

    /**
     * Tests if the whole board is full.
     * @ensures true if all fields are occupied
     * @return true if all fields are occupied
     */
    public boolean isFull() {
        boolean full = true;
        for (Mark mark : fields) { // Iterate over the whole field
            if (mark.equals(Mark.EMPTY)) { // If one of the marks are empty 
                full = false;
            }
        }
        return full;
    }

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole board is full.
     * @ensures true if the board is full or when there is a winner
     * @return true if the game is over
     */
    public boolean gameOver() {
        return isFull() || hasWinner();
    }

    /**
     * Checks whether there is a row which is full and only contains the mark
     * m.
     * @param m the Mark of interest
     * @return true if there is a row controlled by m
     */
    public boolean hasRow(Mark m) {

    	for (int i = 0; i < Board.DIM; i++) { // Iterates over rows

            boolean same = true; // Flag to check if the marks in a row are same

            for (int k = 0; k < Board.DIM; k++) { // Iterates over colums for a row

                if (!fields[(i*Board.DIM)+k].equals(m)) { // If a mark is different
                    same = false;
                }

            }

            if (same) { // If marks in a row are same return true
                return true;
            }
        }

        return false; // If no marks are the same in any row
    }

    /**
     * Checks whether there is a column which is full and only contains the mark
     * m.
     * @param m the Mark of interest
     * @return true if there is a column controlled by m
     */
    public boolean hasColumn(Mark m) {
        
        for (int i = 0; i < Board.DIM; i++) { // Iterates over columns

            boolean same = true; // Flag to check if the marks in a column are same

            for (int k = 0; k < Board.DIM; k++) { // Iterates over rows in a column
                
                if (!fields[(k*Board.DIM)+i].equals(m)) { // If a mark is different
                    same = false;
                }

            }

            if (same) { // If marks in a column are same return true
                return true;
            }
        }

        return false;
    }

    public boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark m.
     * @param m the Mark of interest
     * @return true if there is a diagonal controlled by m
     */
    public boolean hasDiagonal(Mark m) {
        // Flags for detecting whether a diagonal consists of the same mark
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        
        // Check diagonal 1
        for (int i = 0; i < Board.DIAGONAL_1.length; i++) { // Iterate over the diagonal 1 marks 
            if (!fields[Board.DIAGONAL_1[i]].equals(m)) { // If the mark isn't the same 
                diagonal1 = false;
            }
        }

        // Check diagonal 2
        for (int k = 0; k < Board.DIAGONAL_2.length; k++) { // Iterate over the diagonal 2 marks
            if (!fields[Board.DIAGONAL_2[k]].equals(m)) { // If the mark isn't the same
                diagonal2 = false;
            }
        }

        return diagonal1 || diagonal2; // Returns true if either diagonal 1 or diagonal 2 or both are with same marks 
     }

    /**
     * Checks if the mark m has won. A mark wins if it controls at
     * least one row, column or diagonal.
     * @requires m to be either XX or OO
     * @ensures true when m has a row, column or diagonal 
     * @param m the mark of interest
     * @return true if the mark has won
     */
    public boolean isWinner(Mark m) {
        return hasColumn(m) || hasRow(m) || hasDiagonal(m);
    }

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     * @ensures true when either XX or OO has won
     * @return true if the student has a winner.
     */
    public boolean hasWinner() {
        return isWinner(Mark.OO) || isWinner(Mark.XX);
    }

    /**
     * Returns a String representation of this board. In addition to the current
     * situation, the String also shows the numbering of the fields.
     *
     * @return the game situation as String
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
                row = row + " " + getField(i, j).toString() + " ";
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    }

    /**
     * Empties all fields of this board (i.e., let them refer to the value
     * Mark.EMPTY).
     * @ensures all fields are EMPTY
     */
    public void reset() {
    	for (int i = 0; i < fields.length; i++) {
            fields[i] = Mark.EMPTY;
        }
    }

    /**
     * Sets the content of field i to the mark m.
     * @requires i to be a valid field
     * @ensures field i to be set to Mark m
     * @param i the field number (see NUMBERING)
     * @param m the mark to be placed
     */
    public void setField(int i, Mark m) {
        fields[i] = m;
    }

    /**
     * Sets the content of the field represented by the (row,col) pair to the
     * mark m.
     * @requires (row, col) to be a valid field
     * @ensures field (row, col) to be set to Mark m
     * @param row the field's row
     * @param col the field's column
     * @param m the mark to be placed
     */
    public void setField(int row, int col, Mark m) {
    	fields[index(row, col)] = m;
    }
}

package info.binlan;

/**
 * A simple representation of a 3x3 sudoku board. This implementation enforce the 3x3 dimention.
 */
public class SudokuBoard {
    
    private final int[][] board;
    
    public SudokuBoard() {
        board = new int[3][3];
    }
    
    /**
     * Set the value of a cell on a {@link SudokuBoard} instance. Throws {@link IllegalArgumentException} if {@code row}
     * or {@code column} is invalid.
     * 
     * @param value the value to be set.
     * @param row the row index. Trigger {@link IllegalArgumentException} if it is outside {@code [0, 2]}.
     * @param column the column index. Trigger {@link IllegalArgumentException} if it is outside {@code [0, 2]}.
     */
    public void set(final int value, final int row, final int column) {
        validateRowOrColumn(row);
        validateRowOrColumn(column);
        board[row][column] = value;
    }

    /**
     * Get the value of a cell on {@link SudokuBoard} instance. Throws {@link IllegalArgumentException} if {@code row} 
     * or {@code column} is invalid.
     * 
     * @param row the row index. Trigger {@link IllegalArgumentException} if it is outside {@code [0, 2]}.
     * @param column the column index. Trigger {@link IllegalArgumentException} if it is outside {@code [0, 2]}.
     * @return the current value of a cell.
     */
    public int get(final int row, final int column) {
        validateRowOrColumn(row);
        validateRowOrColumn(column);
        return board[row][column];
    }
    
    private void validateRowOrColumn(final int rowOrColumn) {
        if (0 > rowOrColumn || rowOrColumn > 2) {
            throw new IllegalArgumentException("Row or column can only between 0 to 2 inclusively");
        }
    }
}

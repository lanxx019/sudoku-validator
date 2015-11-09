package info.binlan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * A simple validator for {@link SudokuBoard} instance.
 */
public class SudokuValidator {

    /**
     * Validate a {@link SudokuBoard} instance. The board is validate iff:
     * 
     * <pre>
     * 1) It contains number 1 - 9.
     * 2) Each number can only appear once.
     * </pre>
     *  
     * @param board the instance to be validated
     * @return An empty list of {@link InvalidCell} if board is valid. Otherwise, the list contains the information of
     * {@link InvalidCell}'s. The return value cannot be {@code null}.
     */
    public List<InvalidCell> validate(final SudokuBoard board) {
        final ArrayList<InvalidCell> result = new ArrayList<>();
        final HashSet<Integer> seen = new HashSet<>();
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                final int num = board.get(row, column);
                if (num < 1 || num > 9) {
                    result.add(new InvalidCell(num, row, column));
                }
                if (seen.contains(num)) {
                    result.add(new InvalidCell(num, row, column));
                } else {
                    seen.add(num);
                }
            }
        }
        return result;
    }
    
    /**
     * A simple class to represent the information of a invalid cell. It contains the row/column index as well as the 
     * value of the cell.
     */
    public static class InvalidCell {
        private final int row;
        private final int column;
        private final int value;
        
        public InvalidCell(final int value, final int row, final int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
        
        public int getValue() {
            return value;
        }
        
        public int getRow() {
            return row;
        }
        
        public int getColumn() {
            return column;
        }
    }
}

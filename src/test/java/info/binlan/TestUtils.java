package info.binlan;

public class TestUtils {

    public static SudokuBoard create() {
        return TestUtils.create(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
    
    public static SudokuBoard create(final Integer... num) {
        if (num.length != 9) {
            throw new IllegalArgumentException("Sudoku board can only contains 9 numbers");
        }
        final SudokuBoard result = new SudokuBoard();
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                result.set(num[index], row, column);
                index++;
            }
        }
        return result;
    }
}

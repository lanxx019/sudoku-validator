package info.binlan;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import info.binlan.SudokuValidator.InvalidCell;

public class SudokuValidatorUnitTests {

    @Test
    public void testValidateWithInvalidValues() {
        final SudokuValidator validator = new SudokuValidator();
        
        final SudokuBoard board1 = TestUtils.create(1, 2, 3, 4, 5, 6, 7, 8, 0);
        final List<InvalidCell> result1 = validator.validate(board1);
        assertEquals(1, result1.size());
        assertEquals(0, result1.get(0).getValue());
        
        final SudokuBoard board2 = TestUtils.create(1, 2, 3, 4, 5, 6, 7, 8, 10);
        final List<InvalidCell> result2 = validator.validate(board2);
        assertNotNull(result1);
        assertEquals(1, result2.size());
        assertEquals(10, result2.get(0).getValue());
    }
    
    @Test
    public void testValidateWithDuplicateValues() {
        final SudokuValidator validator = new SudokuValidator();
        
        final SudokuBoard board = TestUtils.create(1, 2, 3, 4, 5, 6, 7, 8, 3);
        final List<InvalidCell> result = validator.validate(board);
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).getValue());
    }
    
    @Test
    public void testValidateReturnsCorrectRowColumnIndex() {
        final SudokuValidator validator = new SudokuValidator();
        final SudokuBoard board = TestUtils.create();
        assertTrue(validator.validate(board).isEmpty());
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                final int correctValue = board.get(row, column);
                board.set(10, row, column);
                final List<InvalidCell> result = validator.validate(board);
                assertEquals(10, result.get(0).getValue());
                assertEquals(row, result.get(0).getRow());
                assertEquals(column, result.get(0).getColumn());
                board.set(correctValue, row, column);
            }
        }
    }
    
    @Test
    public void testValidateWithMultipleInvalidCells() {
        final SudokuValidator validator = new SudokuValidator();
        final SudokuBoard board = TestUtils.create();
        assertTrue(validator.validate(board).isEmpty());
        
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board.set(1, row, column);
                final List<InvalidCell> result = validator.validate(board);
                assertEquals(count++, result.size());
            }
        }
    }
}

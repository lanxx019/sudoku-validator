package info.binlan;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuBoardUnitTests {

    @Test
    public void testGet() {
        final SudokuBoard board = TestUtils.create();
        int index = 1;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                assertEquals(index++, board.get(row, column));
            }
        }
    }
    
    @Test
    public void testGetWithInvalidRowOrColumn() {
        final SudokuBoard board = TestUtils.create();
        try {
            board.get(-1, 2);
            fail("-1 is not a valid row");
        } catch (final IllegalArgumentException ignore) {}
        
        try {
            board.get(3, 2);
            fail("3 is not a valid row");
        } catch (final IllegalArgumentException ignore) {}
        
        try {
            board.get(2, -1);
            fail("-1 is not a valid column");
        } catch (final IllegalArgumentException ignore) {}
        
        try {
            board.get(2, 3);
            fail("3 is not a valid column");
        } catch (final IllegalArgumentException ignore) {}
    }
    
    @Test
    public void testSet() {
        final SudokuBoard board = TestUtils.create();
        final int target = 10;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board.set(target, row, column);
                assertEquals(target, board.get(row, column));
            }
        }
    }
    
    @Test
    public void testSetWithInvalidRowOrColumn() {
        final SudokuBoard board = TestUtils.create();
        try {
            board.set(1, -1, 2);
            fail("-1 is not a valid row");
        } catch (final IllegalArgumentException ignore) {}
        
        try {
            board.set(1, 3, 2);
            fail("3 is not a valid row");
        } catch (final IllegalArgumentException ignore) {}
        
        try {
            board.set(1, 2, -1);
            fail("-1 is not a valid column");
        } catch (final IllegalArgumentException ignore) {}
        
        try {
            board.set(1, 2, 3);
            fail("3 is not a valid column");
        } catch (final IllegalArgumentException ignore) {}
    }
}

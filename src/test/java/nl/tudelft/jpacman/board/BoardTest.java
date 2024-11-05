package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the {@link Board} class.
 */
class BoardTest {

    /**
     * Tests creating a valid board and checks its properties.
     */
    @Test
    void testValidBoard() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        Board board = new Board(grid);
        assertNotNull(board, "Board should not be null");

        assertEquals(1, board.getWidth());
        assertEquals(1, board.getHeight());
        assertNotNull(board.squareAt(0, 0), "Square at (0,0) should not be null");
        assertTrue(board.withinBorders(0, 0), "Position (0,0) should be within borders");
        assertFalse(board.withinBorders(1, 1), "Position (1,1) should be outside borders");
    }

    /**
     * Tests creating a board with a null square.
     * Expects an AssertionError to be thrown.
     */
    @Test
    void testBoardWithNullSquare() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        assertThrows(AssertionError.class, () -> new Board(grid), "Creating a board with null square should throw AssertionError");
    }

    /**
     * Tests accessing a square on a board with a null square.
     * Expects an AssertionError to be thrown.
     */
    @Test
    void testBoardWithNullSquareSquareAt() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        assertThrows(AssertionError.class, () -> {
            Board board = new Board(grid);
            board.squareAt(0, 0);
        }, "Accessing a null square should throw AssertionError");
    }
}

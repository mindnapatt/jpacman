package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BoardTest {

    /**
     * Tests that a valid Board instance is correctly initialized
     * with proper width, height, and non-null squares.
     */
    @Test
    void testValidBoard() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        Board board = new Board(grid);

        assertEquals(1, board.getWidth());
        assertEquals(1, board.getHeight());
        assertNotNull(board.squareAt(0, 0));
        assertTrue(board.withinBorders(0, 0));
        assertFalse(board.withinBorders(1, 1));
    }

    /**
     * Tests that creating a Board with a null square throws an AssertionError.
     */
    @Test
    void testBoardWithNullSquare() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        assertThrows(AssertionError.class, () -> {
            Board board = new Board(grid);
        });
    }

    /**
     * Tests that accessing a null square on a Board throws an AssertionError.
     */
    @Test
    void testBoardWithNullSquareSquareAt() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        assertThrows(AssertionError.class, () -> {
            Board board = new Board(grid);
            board.squareAt(0, 0);
        });
    }
}

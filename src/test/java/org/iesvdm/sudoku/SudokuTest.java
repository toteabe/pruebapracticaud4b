package org.iesvdm.sudoku;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class SudokuTest {
    private int gridSize = 9;
    private int numClues = 63;
    private int[][] board;

    @Test
    void failTest() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardBasedInCluesRandomlySolvable();
        //sudoku.fillBoardBasedInCluesRandomly();
        sudoku.printBoard();
    }

    @Test
    void fillBoardRandomly() {
        board = new int[gridSize][gridSize];
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        assertThat(board).isNotNull();
        assertThat(board.length).isEqualTo(gridSize);
    }

    @Test
    void fillBoardBasedInCluesRandomly() {
        board = new int[gridSize][gridSize];
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardBasedInCluesRandomly();
        assertThat(board).isNotNull();
        assertThat(board.length).isEqualTo(gridSize);
    }

    @Test
    void fillBoardBasedInCluesRandomlySolvable() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardBasedInCluesRandomlySolvable();
        assertThat(sudoku.solveBoard()).isTrue();
        //Debería salir true dado que si el método quiere que se pueda resolver el sudoku, tiene que devolver true.
    }

    @Test
    void fillBoardSolvable() {
        Sudoku sudokuAux = new Sudoku();
        sudokuAux.setGridSize(gridSize);
        sudokuAux.fillBoardSolvable();
        assertThat(sudokuAux.solveBoard()).isTrue();
    }

    @Test
    void fillBoardUnsolvable() {
        Sudoku sudokuAux = new Sudoku();
        sudokuAux.setGridSize(gridSize);
        sudokuAux.fillBoardUnsolvable();
        assertThat(sudokuAux.solveBoard()).isFalse();
    }

    @Test
    void copyBoard() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        int[][] boardSrc = new int[gridSize][gridSize];
        sudoku.copyBoard(boardSrc);
        assertThat(boardSrc).isEqualTo(board);
    }

    @Test
    void putNumberInBoard() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        sudoku.putNumberInBoard(1, 2, 3);
        assertThat(sudoku.isNumberInRow(1, 2)).isTrue();
        assertThat(sudoku.isNumberInColumn(1, 3)).isTrue();
    }

    @Test
    void printBoard() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        sudoku.printBoard();
        assertThat(sudoku).isNotNull();
    }


    @Test
    void isNumberInRow() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        sudoku.putNumberInBoard(1, 2, 3);
        assertThat(sudoku.isNumberInRow(1, 2)).isTrue();
    }

    @Test
    void isNumberInRoColumn() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        sudoku.putNumberInBoard(1, 2, 3);
        assertThat(sudoku.isNumberInColumn(1, 3)).isTrue();
    }

    @Test
    void isNumberInBox() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        sudoku.putNumberInBoard(1, 2, 3);
        assertThat(sudoku.isNumberInBox(1, 2, 3)).isTrue();
    }

    @Test
    void isValidPlacement() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        sudoku.putNumberInBoard(1, 2, 3);
        assertThat(sudoku.isValidPlacement(1, 2, 3)).isTrue();
        //En teoría debería salir true dado que si es un sitio valido para poner el número.
    }

    @Test
    void solveBoard() {
        Sudoku sudoku = new Sudoku();
        sudoku.fillBoardRandomly();
        sudoku.solveBoard();
        assertThat(sudoku.solveBoard()).isTrue();
    }
}
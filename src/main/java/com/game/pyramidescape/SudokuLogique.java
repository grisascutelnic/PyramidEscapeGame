package com.game.pyramidescape;

import java.util.Random;

public class SudokuLogique {
    private int[][] board;

    public SudokuLogique() {
        board = new int[9][9];
        initializeBoard();
        generatePuzzle();
    }
    private void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
    }
    boolean isValid(int row, int col, int num) {
        // Verifică dacă numărul este deja pe rând sau coloană
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        // Verifică dacă numărul este deja în subgrila 3x3
        int subgridRow = row - row % 3;
        int subgridCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subgridRow + i][subgridCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (solve()) {
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public int[][] getBoard() {
        return board;
    }
    public void generatePuzzle() {
        solve();
        Random rand = new Random();
        int numToRemove = 1; // Numărul de celule de sudoku de eliminat
        while (numToRemove > 0) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                numToRemove--;
            }
        }
    }
}

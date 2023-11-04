package experimente;

public class CeasLogique {
    private int[][] board;

    public CeasLogique() {
        board = new int[6][6];
        initializeBoard();
    }
    private void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = 0;
            }
        }
    }
    public int[][] getBoard() {
        return board;
    }
}

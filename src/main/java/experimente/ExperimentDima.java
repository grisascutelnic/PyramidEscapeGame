package experimente;
//ExperimentDima
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ExperimentDima extends Application {
    private SudokuGame game = new SudokuGame();
    private GridPane grid = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sudoku Game");

        int[][] board = game.getBoard();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Button cell = new Button(board[row][col] == 0 ? "" : String.valueOf(board[row][col]));
                cell.setMinSize(60, 60);
                cell.setStyle("-fx-font-size: 18;");
                final int r = row;
                final int c = col;
                cell.setOnAction(event -> onCellClick(r, c));
                grid.add(cell, col, row);
            }
        }

        Scene scene = new Scene(grid, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onCellClick(int row, int col) {
        // Implementează aici logica pentru completarea celulei sau orice altă interacțiune dorită.
    }
}



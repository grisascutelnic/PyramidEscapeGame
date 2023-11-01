package experimente;

import experimente.SudokuGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class SudokuInterface extends Application {
    private SudokuGame game = new SudokuGame();
    private GridPane grid = new GridPane();
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Pyramide Escape");

        int[][] board = game.getBoard();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Button cell = new Button(board[row][col] == 0 ? "" : String.valueOf(board[row][col]));
                cell.setMinSize(59, 59);
                cell.setStyle("-fx-font-size: 18;");
                final int r = row;
                final int c = col;

                if (board[row][col] != 0) {
                    cell.setDisable(true); // Blochează celulele cu valori preexistente
                } else {
                    cell.setOnAction(event -> onCellClick(r, c, cell));
                }

                grid.add(cell, col, row);
            }
        }

        // Creează un panou VBox pentru a încadra gridul
        VBox centerPane = new VBox();
        centerPane.getChildren().add(grid);

        // Configurează alinierea panoului pentru a-l centra în mod vertical și orizontal
        centerPane.setAlignment(Pos.CENTER);

        // Plasează panoul centrat în BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(centerPane);

        Scene scene = new Scene(borderPane, 850, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onCellClick(int row, int col, Button cell) {
        int[][] board = game.getBoard();
        int currentValue = board[row][col];

        Platform.runLater(() -> {
            TextInputDialog dialog = new TextInputDialog(currentValue == 0 ? "" : String.valueOf(currentValue));
            dialog.setTitle("Completează celula");
            dialog.setHeaderText("Introdu un număr de la 1 la 9:");
            dialog.setContentText("Număr:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(numStr -> {
                try {
                    int num = Integer.parseInt(numStr);
                    if (num >= 1 && num <= 9) {
                        if (currentValue == 0 || game.isValid(row, col, num)) {
                            board[row][col] = num;
                            cell.setText(String.valueOf(num));
                            cell.setStyle("-fx-font-size: 18; -fx-background-color: #ffcccc;"); // Culoare rosie spalata

                            // Verifică dacă jocul este completat
                            if (isComplete()) {
                                showCongratulations(); // Afișează felicitarea
                            }
                        } else {
                            // Numărul introdus nu este valid
                            showError("Eroare", "Numărul introdus nu este valid.");
                        }
                    } else {
                        // Numărul introdus nu este în intervalul corect
                        showError("Eroare", "Introdu un număr de la 1 la 9.");
                    }
                } catch (NumberFormatException e) {
                    // Nu s-a introdus un număr valid
                    showError("Eroare", "Introdu un număr valid.");
                }
            });
        });
    }

    public boolean isComplete() {
        int[][] board = game.getBoard();

        // Verifică dacă există celule goale
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }

        // Verifică unicitatea valorilor în fiecare rând
        for (int row = 0; row < 9; row++) {
            boolean[] seen = new boolean[10];
            for (int col = 0; col < 9; col++) {
                int num = board[row][col];
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        // Verifică unicitatea valorilor în fiecare coloană
        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[10];
            for (int row = 0; row < 9; row++) {
                int num = board[row][col];
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        // Verifică unicitatea valorilor în fiecare subgrup 3x3
        for (int groupRow = 0; groupRow < 3; groupRow++) {
            for (int groupCol = 0; groupCol < 3; groupCol++) {
                boolean[] seen = new boolean[10];
                for (int row = 3 * groupRow; row < 3 * (groupRow + 1); row++) {
                    for (int col = 3 * groupCol; col < 3 * (groupCol + 1); col++) {
                        int num = board[row][col];
                        if (seen[num]) {
                            return false;
                        }
                        seen[num] = true;
                    }
                }
            }
        }

        return true; // Toate verificările au trecut, jocul este complet
    }

    private void showCongratulations() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Felicitări");
        alert.setHeaderText(null);
        alert.setContentText("Jocul Sudoku a fost completat cu succes!");
        alert.showAndWait();
    }

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

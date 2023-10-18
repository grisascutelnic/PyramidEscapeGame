package experimente;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;

public class ExperimentDima extends Application {
    private SudokuGame game = new SudokuGame();
    private GridPane grid = new GridPane();
    private ImageView imageView = new ImageView();
    private Stage stage;

    private Button createOperatorButton(String operatorSymbol) {
        Button button = new Button(operatorSymbol);
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Sudoku Game");

        Image background = new Image("background.png");
        ImageView backgroundImageView = new ImageView(background);

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

        // Creează un panou VBox pentru a încadra gridul
        VBox centerPane = new VBox();
        centerPane.getChildren().add(grid);

        // Configurează alinierea panoului pentru a-l centra în mod vertical și orizontal
        centerPane.setAlignment(Pos.CENTER);

        // Plasează panoul centrat în BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(centerPane);

        // Adaugă un nou GridPane pentru pătratele numerotate de la 1 la 9
        GridPane numberGrid = new GridPane();
        numberGrid.setHgap(10);
        numberGrid.setVgap(10);
        numberGrid.setPadding(new Insets(10));

        for (int i = 1; i <= 9; i++) {
            String simbol = null;
            if (i == 1)
                simbol = "I";
            if (i == 2)
                simbol = "II";
            if (i == 3)
                simbol = "III";
            if (i == 4)
                simbol = "IV";
            if (i == 5)
                simbol = "V";
            if (i == 6)
                simbol = "VI";
            if (i == 7)
                simbol = "VII";
            if (i == 8)
                simbol = "VIII";
            if (i == 9)
                simbol = "IX";
            Button numberButton = createOperatorButton(simbol);
            numberButton.setMinSize(60, 60);
            numberButton.setStyle("-fx-font-size: 18;");
            numberGrid.add(numberButton, (i - 1) % 9, (i - 1) / 9);
        }

        centerPane.getChildren().add(numberGrid);

        Scene scene = new Scene(borderPane, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onCellClick(int row, int col) {
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
                            Button cell = new Button(String.valueOf(num));
                            cell.setMinSize(58, 58);
                            cell.setStyle("-fx-background-color: #ffad99;-fx-font-size: 18; -fx-text-fill: #000000;");
                            cell.setDisable(true);
                            grid.add(cell, col, row);
                        } else {
                            // Numărul introdus nu este valid
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Eroare");
                            alert.setHeaderText(null);
                            alert.setContentText("Numărul introdus nu este valid.");
                            alert.showAndWait();
                        }
                    } else {
                        // Numărul introdus nu este în intervalul corect
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Eroare");
                        alert.setHeaderText(null);
                        alert.setContentText("Introdu un număr de la 1 la 9.");
                        alert.showAndWait();
                    }
                } catch (NumberFormatException e) {
                    // Nu s-a introdus un număr valid
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Eroare");
                    alert.setHeaderText(null);
                    alert.setContentText("Introdu un număr valid.");
                    alert.showAndWait();
                }
            });
        });
    }

}

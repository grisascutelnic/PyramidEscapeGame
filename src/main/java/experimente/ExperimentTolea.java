package experimente;
import com.game.pyramidescape.SudokuLogique;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ExperimentTolea extends Application {
    private SudokuLogique game = new SudokuLogique();
    private GridPane grid = new GridPane();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {

        Image backgroundImage = new Image("background5.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        stage = primaryStage;
        primaryStage.setTitle("Pyramide Escape");

        int[][] board = game.getBoard();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                Button cell = new Button();
                cell.setMinSize(68, 68);
                cell.setStyle("-fx-font-size: 18;");
                grid.add(cell, col, row);
            }
        }

        // Configurează alinierea gridului la centru în mod vertical și orizontal
        grid.setAlignment(Pos.CENTER);

        // Creează un panou VBox pentru a încadra gridul și imaginea de fundal
        StackPane centerPane = new StackPane();
        centerPane.getChildren().addAll(backgroundImageView, grid);

        // Plasează panoul centrat în BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(centerPane);

        Scene scene = new Scene(borderPane, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }



}

package experimente;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import java.util.Random;

public class ExperimentTolea extends Application {
    private CeasLogique game = new CeasLogique();
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


                // Declarați o variabilă pentru a ține evidența stării celulei (colorată sau nu)
                final boolean[] isColored = {false};

                cell.setOnAction(e -> {
                    if (isColored[0]) {
                        // Dacă celula este deja colorată, revino la culoarea inițială
                        cell.setStyle("-fx-font-size: 18;");
                        isColored[0] = false;
                    } else {
                        // Altfel, colorează celula
                        cell.setStyle("-fx-background-color: burlywood; -fx-font-size: 18;");
                        isColored[0] = true;
                    }
                });


                grid.add(cell, col, row);
            }
        }



        Random random = new Random();

        // Generăm 6 cifre aleatoare
        int randomNumber1 = random.nextInt(2);
        int randomNumber2 = random.nextInt(4);
        int randomNumber3 = random.nextInt(5);
        int randomNumber4 = random.nextInt(9);
        int randomNumber5 = random.nextInt(5);
        int randomNumber6 = random.nextInt(9);

        // Creăm un Label pentru a afișa numărul generat
        Label randomLabel = new Label("" + randomNumber1 + randomNumber2 + " : " + randomNumber3 + randomNumber4 + " : " + randomNumber5 + randomNumber6);
        randomLabel.setTranslateY(-270);
        randomLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 50));
        randomLabel.setTextFill(Color.FIREBRICK);


        // Creăm un layout VBox pentru a afișa eticheta în centru
        StackPane root = new StackPane(randomLabel);

        Image backgroundceas = new Image("backgroundceas.jpg");
        ImageView imageViewCeas = new ImageView(backgroundceas);

        imageViewCeas.setFitWidth(450);
        imageViewCeas.setFitHeight(100);
        imageViewCeas.setTranslateY(-270);



        // Configurează alinierea gridului la centru în mod vertical și orizontal
        grid.setAlignment(Pos.CENTER);

        // Creează un panou VBox pentru a încadra gridul și imaginea de fundal
        StackPane centerPane = new StackPane();
        centerPane.getChildren().addAll(backgroundImageView, grid , imageViewCeas , randomLabel);

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

package experimente;
import com.game.pyramidescape.CeleTreiUsi;
import com.game.pyramidescape.SudokuLogique;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class ExperimentTolea extends Application {
    private CeasLogique game = new CeasLogique();
    private GridPane grid = new GridPane();
    private GridPane grid2 = new GridPane();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {

        Image backgroundImage = new Image("background5.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        stage = primaryStage;
        primaryStage.setTitle("Pyramide Escape");

        Random random = new Random();
        // Generăm 6 cifre aleatoare
        int randomNumber1 = random.nextInt(2);
        int randomNumber2 = random.nextInt(4);
        int randomNumber3 = random.nextInt(5);
        int randomNumber4 = random.nextInt(9);
        int randomNumber5 = random.nextInt(5);
        int randomNumber6 = random.nextInt(9);

        // Convertirea în reprezentări binare
        String binary1 = Integer.toBinaryString(randomNumber1);
        String binary2 = Integer.toBinaryString(randomNumber2);
        String binary3 = Integer.toBinaryString(randomNumber3);
        String binary4 = Integer.toBinaryString(randomNumber4);
        String binary5 = Integer.toBinaryString(randomNumber5);
        String binary6 = Integer.toBinaryString(randomNumber6);

        System.out.println("Random Number 1: " + randomNumber1 + " in binary: " + binary1);
        System.out.println("Random Number 2: " + randomNumber2 + " in binary: " + binary2);
        System.out.println("Random Number 3: " + randomNumber3 + " in binary: " + binary3);
        System.out.println("Random Number 4: " + randomNumber4 + " in binary: " + binary4);
        System.out.println("Random Number 5: " + randomNumber5 + " in binary: " + binary5);
        System.out.println("Random Number 6: " + randomNumber6 + " in binary: " + binary6);

        // gridul care il afisam
        int[][] board = game.getBoard();
        grid.setHgap(6); // Spațiul orizontal între celule
        grid.setVgap(6); // Spațiul vertical între celule
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 4; col++) {
                Button cell = new Button();
                cell.setMinSize(68, 68);
                cell.setStyle("-fx-font-size: 18; -fx-background-radius: 10;");

                cell.setOnMouseClicked(e -> {
                    if (e.getButton() == MouseButton.PRIMARY) {
                        // La clicul stânga (buton primar), colorează celula în alb
                        cell.setStyle("-fx-background-color: white; -fx-font-size: 18;");
                    } else if (e.getButton() == MouseButton.SECONDARY) {
                        // La clicul dreapta (buton secundar), colorează celula în burlywood
                        cell.setStyle("-fx-background-color: burlywood; -fx-font-size: 18;");
                    }
                });

                grid.add(cell, col, row);
            }
        }



        //cream gridul corect care ramane in fundal
        int[][] board2 = game.getBoard();
        int[] binaryNumbers = {randomNumber1, randomNumber2, randomNumber3, randomNumber4, randomNumber5, randomNumber6};

        for (int row2 = 0; row2 < 6; row2++) {
            int currentNumber = binaryNumbers[row2]; // Obține numărul binar corespunzător rândului

            for (int col2 = 0; col2 < 4; col2++) {
                Button cell2 = new Button();
                cell2.setMinSize(68, 68);
                cell2.setStyle("-fx-font-size: 18; -fx-background-radius: 10;");

                // Declarați o variabilă pentru a ține evidența stării celulei (colorată sau nu)
                final boolean[] isColored2 = {false};

                int bitValue = (currentNumber >> (3 - col2)) & 1; // Obține valoarea bitului corespunzător coloanei curente

                cell2.setOnAction(e -> {
                    if (isColored2[0]) {
                        // Dacă celula este deja colorată, revino la culoarea inițială
                        cell2.setStyle("-fx-font-size: 18;");
                        isColored2[0] = false;
                    } else {
                        if (bitValue == 1) {
                            // Dacă bitul este 1, colorează celula cu altă culoare
                            cell2.setStyle("-fx-background-color: burlywood; -fx-font-size: 18;");
                        } else {
                            // Dacă bitul este 0, colorează celula cu o altă culoare
                            cell2.setStyle("-fx-background-color: white; -fx-font-size: 18;");
                        }
                        isColored2[0] = true;
                    }
                });

                grid2.add(cell2, col2, row2);
            }
        }

        //Back button
        Button back = new Button();
        back.setPrefSize(120, 50);
        Image imageBack = new Image("BackButton.png");
        ImageView imageView1 = new ImageView(imageBack);
        back.setGraphic(imageView1);
        imageView1.setFitWidth(120);
        imageView1.setFitHeight(50);
        back.getStyleClass().add("back");

        back.setTranslateY(-300);
        back.setTranslateX(400);

        back.setOnAction(e -> {
            CeleTreiUsi treiUsi = new CeleTreiUsi();
            treiUsi.start(primaryStage);
        });



        // Creăm un Label pentru a afișa numărul generat
        Label randomLabel = new Label("" + randomNumber1 + randomNumber2 + " : " + randomNumber3 + randomNumber4 + " : " + randomNumber5 + randomNumber6);
        randomLabel.setTranslateY(-280);
        randomLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 50));
        randomLabel.setTextFill(Color.FIREBRICK);


        // Creăm un layout VBox pentru a afișa eticheta în centru
        StackPane root = new StackPane(randomLabel);

        Image backgroundceas = new Image("backgroundceas.jpg");
        ImageView imageViewCeas = new ImageView(backgroundceas);

        imageViewCeas.setFitWidth(450);
        imageViewCeas.setFitHeight(100);
        imageViewCeas.setTranslateY(-280);



        // Configurează alinierea gridului la centru în mod vertical și orizontal
        grid.setAlignment(Pos.CENTER);

        // Creează un panou VBox pentru a încadra gridul și imaginea de fundal
        StackPane centerPane = new StackPane();
        centerPane.getChildren().addAll(backgroundImageView, grid , imageViewCeas , randomLabel , back);

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

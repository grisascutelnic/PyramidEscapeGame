package experimente;

import com.game.pyramidescape.CeleTreiUsi;
import com.game.pyramidescape.ParticleAnimation;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Random;


public class ExperimentTolea extends Application {
    private final CeasLogique game = new CeasLogique();
    private final GridPane grid = new GridPane();
    private final GridPane grid2 = new GridPane();
    private boolean gridBlocat = false;

    @Override
    public void start(Stage primaryStage) {

        Image backgroundImage = new Image("backInterfata1.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);


        primaryStage.setTitle("Pyramide Escape");

        Random random = new Random();
        // Generăm 6 cifre aleatoare
        int randomNumber1 = random.nextInt(2);
        int randomNumber2 = random.nextInt(4);
        int randomNumber3 = random.nextInt(5);
        int randomNumber4 = random.nextInt(9);
        int randomNumber5 = random.nextInt(5);
        int randomNumber6 = random.nextInt(9);


        // gridul care il afisam
        game.getBoard();
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
                        cell.setStyle("-fx-background-color: white; -fx-font-size: 18; -fx-background-radius: 10;");
                    } else if (e.getButton() == MouseButton.SECONDARY) {
                        // La clicul dreapta (buton secundar), colorează celula în burlywood
                        cell.setStyle("-fx-background-color: burlywood; -fx-font-size: 18; -fx-background-radius: 10;");
                    }
                });

                grid.add(cell, col, row);
            }
        }


        //cream gridul corect care ramane in fundal
        game.getBoard();
        int[] binaryNumbers = {randomNumber1, randomNumber2, randomNumber3, randomNumber4, randomNumber5, randomNumber6};

        for (int row2 = 0; row2 < 6; row2++) {
            int currentNumber = binaryNumbers[row2]; // Obține numărul binar corespunzător rândului

            for (int col2 = 0; col2 < 4; col2++) {
                Button cell2 = new Button();
                cell2.setMinSize(68, 68);
                cell2.setStyle("-fx-font-size: 18; -fx-background-radius: 10;");


                int bitValue = (currentNumber >> (3 - col2)) & 1; // Obține valoarea bitului corespunzător coloanei curente

                if (bitValue == 1) {
                    // Dacă bitul este 1, colorează celula cu altă culoare
                    cell2.setStyle("-fx-background-color: burlywood; -fx-font-size: 18; -fx-background-radius: 10;");
                } else {
                    // Dacă bitul este 0, colorează celula cu o altă culoare
                    cell2.setStyle("-fx-background-color: white; -fx-font-size: 18; -fx-background-radius: 10;");
                }

                grid2.add(cell2, col2, row2);
            }
        }

        Button verificareButton = new Button("Verifică ");
        Text rezultatText = new Text();


        verificareButton.setOnAction(e -> {
            if (gridBlocat) {
                return; // Nu permiteți verificarea dacă grid-ul este deja blocat
            }
            boolean identice = areGridsIdentice(grid, grid2);
            if (identice) {
                rezultatText.setText("Gridurile sunt identice.");
                System.out.println("da");
                gridBlocat = true;// Blocați grid-ul după verificare
                showCongratulations();
            } else {
                rezultatText.setText("Gridurile nu sunt identice. Reseting grid...");
                resetGrid(grid);
                System.out.println("nu");
            }
        });


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
        randomLabel.getStyleClass().add("textCeas");

        // Creăm un layout VBox pentru a afișa eticheta în centru
        new StackPane(randomLabel);



        // Configurează alinierea gridului la centru în mod vertical și orizontal
        grid.setAlignment(Pos.CENTER);

        // Creează un panou VBox pentru a încadra tot
        StackPane centerPane = new StackPane();
        VBox bottomPane = new VBox(10); // Creăm un VBox pentru a aranja butonul de verificare și textul sub grid
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.getChildren().addAll(verificareButton, rezultatText);

        VBox centerVBox = new VBox(10); // Creăm un VBox pentru a aranja grid-ul și bottomPane vertical
        centerVBox.getChildren().addAll(grid, bottomPane);
        centerVBox.setAlignment(Pos.CENTER);

        centerPane.getChildren().addAll(backgroundImageView, centerVBox, randomLabel, back);


        ParticleAnimation particleAnimation = new ParticleAnimation();
        centerPane.getChildren().add(particleAnimation.getParticleGroup());

        // Plasează panoul centrat în BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(centerPane);


        Scene scene = new Scene(borderPane, 1000, 700);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    boolean areGridsIdentice(GridPane grid1, GridPane grid2) {
        if (grid1.getRowCount() != grid2.getRowCount() || grid1.getColumnCount() != grid2.getColumnCount()) {
            return false; // Verifică dacă numărul de rânduri și coloane este același
        }

        for (int row = 0; row < grid1.getRowCount(); row++) {
            for (int col = 0; col < grid1.getColumnCount(); col++) {
                Button cell1 = (Button) grid1.getChildren().get(row * grid1.getColumnCount() + col);
                Button cell2 = (Button) grid2.getChildren().get(row * grid2.getColumnCount() + col);

                if (!cell1.getStyle().equals(cell2.getStyle())) {
                    return false; // Verifică dacă stilul celulelor nu este același
                }
            }
        }

        return true; // Grid-urile sunt identice
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void resetGrid(GridPane grid) {
                if (!gridBlocat) {
                    // ștergeți toate celulele din grid-ul afișat și adăugați celulele din noul grid
                    grid.getChildren().clear();
                    grid.getChildren().addAll(grid.getChildren());

                    game.getBoard();
                    for (int row = 0; row < 6; row++) {
                        for (int col = 0; col < 4; col++) {
                            Button cell = new Button();
                            cell.setMinSize(68, 68);
                            cell.setStyle("-fx-font-size: 18; -fx-background-radius: 10;");

                            cell.setOnMouseClicked(e -> {
                                if (e.getButton() == MouseButton.PRIMARY) {
                                    // La clicul stânga (buton primar), colorează celula în alb
                                    cell.setStyle("-fx-background-color: white; -fx-font-size: 18; -fx-background-radius: 10;");
                                } else if (e.getButton() == MouseButton.SECONDARY) {
                                    // La clicul dreapta (buton secundar), colorează celula în burlywood
                                    cell.setStyle("-fx-background-color: burlywood; -fx-font-size: 18; -fx-background-radius: 10;");
                                }
                            });

                            grid.add(cell, col, row);

                        }
                    }
                }
    }

    private void showCongratulations() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Felicitări");
        alert.setHeaderText(null);
        alert.setContentText("Ai primit un fragment din cheie!");
        alert.showAndWait();
    }
}



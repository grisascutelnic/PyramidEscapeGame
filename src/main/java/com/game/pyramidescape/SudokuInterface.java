package com.game.pyramidescape;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Optional;

public class    SudokuInterface extends Application {
    private SudokuLogique game = new SudokuLogique();
    private GridPane grid = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        Image backgroundImage = new Image("backInterfata1.jpg");
        ImageView backgroundImageView = new ImageView(backgroundImage);

        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        Image cleopatra = new Image("Cleopatra.png");
        ImageView cleopatraImageView = new ImageView(cleopatra);

        cleopatraImageView.setFitWidth(250);
        cleopatraImageView.setFitHeight(270);

        cleopatraImageView.setTranslateX(400);
        cleopatraImageView.setTranslateY(-100);

        Image cleopatraOglindita = new Image("cleopatraOglindita.png");
        ImageView cleopatraOglinditaImageView = new ImageView(cleopatraOglindita);

        cleopatraOglinditaImageView.setFitWidth(250);
        cleopatraOglinditaImageView.setFitHeight(270);

        cleopatraOglinditaImageView.setTranslateX(-400);
        cleopatraOglinditaImageView.setTranslateY(120);

        stage = primaryStage;
        primaryStage.setTitle("Pyramid Escape Game");

        int[][] board = game.getBoard();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Button cell = new Button(board[row][col] == 0 ? "" : String.valueOf(board[row][col]));
                cell.setMinSize(64, 64);
                cell.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-font-family: \"Comic Sans MS\"; -fx-background-radius: 10;");
                cell.setOnMouseEntered(event -> {
                    cell.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-font-family: \"Comic Sans MS\"; -fx-background-radius: 10; -fx-background-color: #ffcce0;"); //Culoarecare se schimba
                });
                cell.setOnMouseExited(event -> {
                    cell.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-font-family: \"Comic Sans MS\"; -fx-background-radius: 10;");
                });

                final int r = row;
                final int c = col;

                if (board[row][col] != 0) {
                    cell.setDisable(true); // Blochează celulele cu valori preexistente
                } else {
                    cell.setOnAction(event -> onCellClick(r, c, cell, primaryStage));
                }
                grid.add(cell, col, row);
            }
        }

        // Configurează alinierea gridului la centru în mod vertical și orizontal
        grid.setAlignment(Pos.CENTER);

        // Creează un panou VBox pentru a încadra gridul și imaginea de fundal
        StackPane centerPane = new StackPane();

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

        centerPane.getChildren().addAll(backgroundImageView, grid, back, cleopatraImageView, cleopatraOglinditaImageView);
        /*hintLabel*/

        // Adaugă animația de particule de praf
        ParticleAnimation particleAnimation = new ParticleAnimation();
        centerPane.getChildren().add(particleAnimation.getParticleGroup());

        // Plasează panoul centrat în BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(centerPane);

        Scene scene = new Scene(borderPane, 1000, 700);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onCellClick(int row, int col, Button cell, Stage primaryStage) {
        stage = primaryStage;
        int[][] board = game.getBoard();
        int currentValue = board[row][col];

        Platform.runLater(() -> {
            TextInputDialog dialog = new TextInputDialog(currentValue == 0 ? "" : String.valueOf(currentValue));
            dialog.setTitle("Pyramide Escape Game");
            dialog.setHeaderText("Introdu un număr de la 1 la 9:");

            // Încercăm să ascundem butonul de ajutor, dacă există
            final ButtonType helpButtonType = new ButtonType("?", ButtonBar.ButtonData.HELP_2);
            final Node helpButton = dialog.getDialogPane().lookupButton(helpButtonType);
            if (helpButton != null) {
                helpButton.setVisible(false);
                helpButton.managedProperty().bind(helpButton.visibleProperty());
            }

            // Adăugați stiluri personalizate pentru dialog, dacă este necesar
            dialog.getDialogPane().setStyle("-fx-font-size: 16px;"); // Exemplu de modificare a stilului pane-ului dialogului
            dialog.getDialogPane().lookup(".content.label").setStyle("-fx-font-size: 14px;"); // Exemplu de modificare a stilului textului din dialog

            // Restul codului pentru gestionarea răspunsului utilizatorului
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(numStr -> {
                try {
                    int num = Integer.parseInt(numStr);
                    if (num >= 1 && num <= 9) {
                        if (game.isValid(row, col, num)) {
                            board[row][col] = num;
                            cell.setText(String.valueOf(num));
                            cell.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-font-family: \"Comic Sans MS\"; -fx-background-radius: 16;  -fx-background-color: #ffb3b3;");
                            cell.setOnMouseEntered(event -> {
                                cell.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-font-family: \"Comic Sans MS\"; -fx-background-radius: 16; -fx-background-color: #ffb3b3;");
                            });
                            cell.setOnMouseExited(event -> {
                                cell.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-font-family: \"Comic Sans MS\"; -fx-background-radius: 16; -fx-background-color: #ffbf80;");
                            });

                            // Verifică dacă jocul este completat
                            if (isComplete()) {
                                FelicitareCheie felicitare = new FelicitareCheie();
                                felicitare.start(primaryStage); // Afișează felicitarea
                            }
                        } else {
                            // Numărul introdus nu este valid
                            showError("Un alt numar boule!");
                            // Reveniți la valoarea anterioară a celulei
                            cell.setText(currentValue == 0 ? "" : String.valueOf(currentValue));
                        }
                    } else {
                        // Numărul introdus nu este în intervalul corect
                        showError("Introdu un număr de la 1 la 9.");
                    }
                } catch (NumberFormatException e) {
                    // Nu s-a introdus un număr valid
                    showError("Un alt numar boule!");
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
        alert.setContentText("Ai primit un fragment din cheie!");
        alert.showAndWait();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Eroare");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
package experimente;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;git

import java.util.Random;
public class ExperimentTolea extends Application {

        private String[] words = {"JAVA", "PYTHON", "PROGRAMMING", "COMPUTER", "DEVELOPER", "CODE"};
        private String wordToGuess;
        private StringBuilder currentGuess;
        private int attemptsLeft = 16;

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            Random random = new Random();
            wordToGuess = words[random.nextInt(words.length)];
            currentGuess = new StringBuilder(wordToGuess.replaceAll("[a-zA-Z]", "_"));

            Label wordLabel = new Label(currentGuess.toString());
            TextField letterInput = new TextField();
            Button guessButton = new Button("Guess");
            Label attemptsLabel = new Label("Attempts left: " + attemptsLeft);

            guessButton.setOnAction(e -> {
                String letter = letterInput.getText().toUpperCase();
                if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
                    if (wordToGuess.contains(letter)) {
                        for (int i = 0; i < wordToGuess.length(); i++) {
                            if (wordToGuess.charAt(i) == letter.charAt(0)) {
                                currentGuess.setCharAt(i, letter.charAt(0));
                            }
                        }
                        wordLabel.setText(currentGuess.toString());
                    } else {
                        attemptsLeft--;
                        attemptsLabel.setText("Attempts left: " + attemptsLeft);
                        if (attemptsLeft == 0) {
                            endGame("You lost! The word was: " + wordToGuess);
                        }
                    }
                } else {
                    showAlert("Invalid input. Please enter a single letter.");
                }

                if (currentGuess.toString().equals(wordToGuess)) {
                    endGame("Congratulations! You guessed the word: " + wordToGuess);
                }

                letterInput.clear();
            });

            VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);
            layout.getChildren().addAll(wordLabel, letterInput, guessButton, attemptsLabel);

            Scene scene = new Scene(layout, 600, 450);
            primaryStage.setTitle("Guess the Word Game");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void endGame(String message) {
            showAlert(message);
            System.exit(0);
        }

        private void showAlert(String message) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }
}

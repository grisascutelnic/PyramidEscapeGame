package experimente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Experimente extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scena Principală");

        // Creare buton pentru a trece la scena nouă
        Button button = new Button("Trece la Scena Nouă");
        button.setOnAction(e -> {
            // Creare stadiu pentru scena nouă
            Stage secondaryStage = new Stage();
            secondaryStage.setTitle("Scena Nouă");

            // Creare rădăcină pentru scena nouă
            StackPane secondaryLayout = new StackPane();
            Scene newScene = new Scene(secondaryLayout, 230, 100);

            // Setare scene pentru stadiul nou
            secondaryStage.setScene(newScene);

            // Afișare stadiu nou
            secondaryStage.show();

            // Opțiunea de a închide stadiul principal după trecerea la stadiul nou
            // primaryStage.close();
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


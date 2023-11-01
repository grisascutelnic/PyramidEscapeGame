package experimente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Nivel1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nivel 1");

        Button btnNivel1 = new Button("Interfata");
        btnNivel1.setOnAction(e -> {
            Interfata nivel1 = new Interfata();
            nivel1.start(new Stage());
            primaryStage.close();
        });


        HBox layout = new HBox(20); // HBox pentru aranjare orizontală
        layout.getChildren().addAll(btnNivel1);

        Scene scene = new Scene(layout, 400, 200);
        //scene.setStyle("-fx-background-color: lightblue");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

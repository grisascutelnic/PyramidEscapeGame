package experimente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class Interfata extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Interfata");

        Button btnNivel1 = new Button("Nivel 1");
        btnNivel1.setOnAction(e -> {
            Nivel1 nivel1 = new Nivel1();
            nivel1.start(new Stage());
            primaryStage.close();
        });

        Button btnNivel2 = new Button("Nivel 2");
        btnNivel2.setOnAction(e -> {
            Nivel2 nivel2 = new Nivel2();
            nivel2.start(new Stage());
            primaryStage.close();
        });

        HBox layout = new HBox(20); // HBox pentru aranjare orizontală
        layout.getChildren().addAll(btnNivel1, btnNivel2);

        Scene scene = new Scene(layout, 400, 200);
        //scene.setStyle("-fx-background-color: lightblue");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

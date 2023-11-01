package experimente;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interfata extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Creăm butoanele pentru navigare
        Button nivel1Button = new Button("Nivel 1");
        Button nivel2Button = new Button("Nivel 2");

        // Setăm acțiuni pentru butoane
        nivel1Button.setOnAction(e -> {
            Stage nivel1Stage = new Stage();
            Nivel1 nivel1 = new Nivel1();
            nivel1.start(nivel1Stage);
        });


        nivel2Button.setOnAction(e -> {
            // Deschide clasa Nivel2
            Nivel2 nivel2 = new Nivel2();
            nivel2.start(primaryStage);
        });

        // Creăm o interfață cu butoanele
        VBox root = new VBox(10);
        root.getChildren().addAll(nivel1Button, nivel2Button);

        // Afișăm interfața în scenă
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Nivel de Interfata");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

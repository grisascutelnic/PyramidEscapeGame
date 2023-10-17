package experimente;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Nivele extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("Pagina Principală");

        // Încărcați imaginea de fundal pentru Pagina Principală
        Image background = new Image("background.png");
        ImageView backgroundImageView = new ImageView(background);
        backgroundImageView.setFitWidth(1000);
        backgroundImageView.setFitHeight(700);

        Nivel1 pagina1 = new Nivel1(stage);
        Nivel2 pagina2 = new Nivel2(stage);

        // Buton pentru Nivelul 1
        Button button1 = new Button("Nivel 1");
        button1.setOnAction(e -> afiseazaNivel1());

        // Buton pentru Nivelul 2
        Button button2 = new Button("Nivel 2");
        button2.setOnAction(e -> afiseazaNivel2());

        // Așezați butoanele într-un VBox
        VBox buttonBox = new VBox(10); // 10 este spațiul între butoane
        buttonBox.getChildren().addAll(button1, button2);
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);

        // Așezați imaginea de fundal și butoanele într-un StackPane
        StackPane layout = new StackPane();
        layout.getChildren().addAll(backgroundImageView, buttonBox);

        Scene scene = new Scene(layout, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }

    private void afiseazaNivel1() {
        Nivel1 nivel1 = new Nivel1(stage);
        stage.setScene(nivel1.getScene());
    }

    private void afiseazaNivel2() {
        Nivel2 nivel2 = new Nivel2(stage);
        stage.setScene(nivel2.getScene());
    }
}

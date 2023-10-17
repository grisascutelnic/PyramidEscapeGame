package experimente;

import javafx.application.Application;
import javafx.stage.Stage;

public class Nivele extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;


        Nivel1 pagina1 = new Nivel1(stage);
        Nivel2 pagina2 = new Nivel2(stage);

        stage.setScene(pagina1.getScene());
        stage.setTitle("Navigare între pagini");
        stage.show();
    }
}

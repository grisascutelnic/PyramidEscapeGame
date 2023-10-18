package experimente;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Nivel1 {
    private Scene pagina1;

    public Nivel1(Stage stage) {
        Circle cercAlbastru = new Circle(100, Color.BLUE);
        Button button1 = new Button("Navighează la Pagina 2");
        button1.setOnAction(e -> afiseazaPagina2(stage));
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll(cercAlbastru, button1);
        pagina1 = new Scene(layout1, 800, 600);
    }

    public Scene getScene() {
        return pagina1;
    }

    private void afiseazaPagina2(Stage stage) {
        stage.setScene(new Nivel2(stage).getScene());
    }
}

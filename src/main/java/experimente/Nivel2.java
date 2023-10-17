package experimente;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Nivel2 {
    private Scene pagina2;

    public Nivel2(Stage stage) {
        Rectangle patratGalben = new Rectangle(200, 200, Color.RED);
        Button button2 = new Button("Navighează la Pagina 1");
        button2.setOnAction(e -> afiseazaPagina1(stage));
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(patratGalben, button2);
        pagina2 = new Scene(layout2, 600, 600);
    }

    public Scene getScene() {
        return pagina2;
    }

    private void afiseazaPagina1(Stage stage) {
        stage.setScene(new Nivel1(stage).getScene());
    }
}

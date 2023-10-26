// În clasa Introducere, vom adăuga codul pentru a crea o scenă nouă
package com.game.pyramidescape;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Introducere {

    public static Scene createIntroducereScene() {
        // Creăm un layout StackPane pentru scena Introducere
        StackPane introducereLayout = new StackPane();
        Scene introducereScene = new Scene(introducereLayout, 1000, 700);

        // Adăugăm un pătrat albastru pe scenă
        Rectangle blueSquare = new Rectangle(200, 200); // Dimensiunile pătratului
        blueSquare.setFill(Color.BLUE); // Setăm culoarea pătratului
        introducereLayout.getChildren().add(blueSquare);

        return introducereScene;
    }
}

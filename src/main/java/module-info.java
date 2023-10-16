module com.game.pyramidescapegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.pyramidescapegame to javafx.fxml;
    exports com.game.pyramidescapegame;
}
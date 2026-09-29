package it.unibo.gridgames;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(final Stage stage) {
        final Label label = new Label("JavaFX è configurato correttamente!");
        final Scene scene = new Scene(new StackPane(label), 400, 200);
        stage.setTitle("Grid Games - Check JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}

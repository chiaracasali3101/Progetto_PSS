package it.unibo.gridgames;

import it.unibo.gridgames.view.MainAppView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(final Stage stage) {
        /*final Label label = new Label("JavaFX è configurato correttamente!");
        final Scene scene = new Scene(new StackPane(label), 400, 200);
        stage.setTitle("Grid Games - Check JavaFX");
        stage.setScene(scene);
        stage.show();
        */
       final MainAppView view = new MainAppView();
        final Scene scene = new Scene(view, 500, 400);

        stage.setTitle("GridGames");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Application entry point for JavaFX runtime.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        launch(args);
    }
}

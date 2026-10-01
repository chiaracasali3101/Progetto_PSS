package it.unibo.gridgames.view;

import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class LeaderboardView extends BorderPane {
    private final Button btnBack = new Button("Indietro");

    public LeaderboardView() {
        this.setStyle("-fx-background-color: #f7f9fa;");

        this.setTop(this.btnBack);
        BorderPane.setMargin(this.btnBack, new Insets(15));

        btnBack.setStyle("-fx-background-color: darkorange; -fx-text-fill: white; -fx-font-weight: bold;");

    }

    /**
     * Sets the action handler for the back button
     * @param handler
     */
    public void setOnBackSelected(final Runnable handler) {
        this.btnBack.setOnAction(e -> handler.run());
    }
}

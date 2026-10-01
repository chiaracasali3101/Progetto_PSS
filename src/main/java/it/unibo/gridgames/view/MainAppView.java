package it.unibo.gridgames.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainAppView extends BorderPane {

        //bottoni
        private final Button btn2048 = new Button("2048");
        private final Button btnSudoku = new Button("Sudoku");
        private final Button btn15Game = new Button("Gioco del 15");
        private final Button btnLeaderboard = new Button("Classifica");

    public MainAppView() {
        final Label titleLabel = new Label("GridGames");
        BorderPane.setAlignment(titleLabel, Pos.CENTER); //titolo in alto al centro
        BorderPane.setMargin(titleLabel, new Insets(30, 0, 20, 0));
        this.setTop(titleLabel);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36)); //testo
        titleLabel.setTextFill(Color.DARKORANGE); //colore
       
        //griglia per i bottoni
        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(btn2048, 0, 0);
        btn2048.setStyle("-fx-background-color: darkorange; -fx-text-fill: white; -fx-font-weight: bold;");
        btn2048.setStyle("-fx-background-color: #e67e22; -fx-text-fill: white; -fx-background-radius: 8;");
        grid.add(btn15Game, 1, 0);
        btn15Game.setStyle("-fx-background-color: darkorange; -fx-text-fill: white; -fx-font-weight: bold;");
        btn15Game.setStyle("-fx-background-color: #e67e22; -fx-text-fill: white; -fx-background-radius: 8;");
        grid.add(btnSudoku, 0, 1);
        btnSudoku.setStyle("-fx-background-color: darkorange; -fx-text-fill: white; -fx-font-weight: bold;");
        btnSudoku.setStyle("-fx-background-color: #e67e22; -fx-text-fill: white; -fx-background-radius: 8;");
        grid.add(btnLeaderboard, 1, 1);
        btnLeaderboard.setStyle("-fx-background-color: darkorange; -fx-text-fill: white; -fx-font-weight: bold;");
        btnLeaderboard.setStyle("-fx-background-color: #e67e22; -fx-text-fill: white; -fx-background-radius: 8;");

        this.setCenter(grid); //gliglia al centro
    }

    /**
     * Sets the action handler for the 2048 button
     * @param handler
     */
    public void setOn2048Selected(final Runnable handler) {
        this.btn2048.setOnAction(e -> handler.run());
    }

    /**
     * Sets the action handler for the Gioco del 15 button
     * @param handler
     */
    public void setOnGiocoDel1Selected(final Runnable handler) {
        this.btn15Game.setOnAction(e -> handler.run());
    }

    /**
     *  Sets the action handler for the Sudoku button
     * @param handler
     */
    public void setOnSudokuSelected(final Runnable handler) {
        this.btnSudoku.setOnAction(e -> handler.run());
    }

    /**
     * Sets the action handler for the Classifica button
     * @param handler
     */
    public void setOnClassificaSelected(final Runnable handler) {
        this.btnLeaderboard.setOnAction(e -> handler.run());
    }
}

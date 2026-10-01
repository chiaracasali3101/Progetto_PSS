package it.unibo.gridgames.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainAppView extends BorderPane {
    public MainAppView() {
        final Label titleLabel = new Label("GridGames");
        BorderPane.setAlignment(titleLabel, Pos.CENTER); //titolo in alto al centro
        BorderPane.setMargin(titleLabel, new Insets(30, 0, 20, 0));
        this.setTop(titleLabel);
       
        //bottoni
        final Button btn2048 = new Button("2048");
        final Button btnGiocoDel15 = new Button("Gioco del 15");
        final Button btnSudoku = new Button("Sudoku");
        final Button btnClassifica = new Button("Classifica");

        //griglia per i bottoni
        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(btn2048, 0, 0);
        grid.add(btnGiocoDel15, 1, 0);
        grid.add(btnSudoku, 0, 1);
        grid.add(btnClassifica, 1, 1);

        this.setCenter(grid); //gliglia al centro
    }
}

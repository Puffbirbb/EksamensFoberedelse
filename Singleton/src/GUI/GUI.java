package GUI;

import Controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 4");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> names = new ArrayList<>();
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        GridPane.setValignment(lblName, VPos.TOP);
        
        pane.add(txfName, 1, 0, 1, 1);

        pane.add(lvwNames, 0, 1,3,1);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);

        lvwNames.getItems().setAll(this.initNames());

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 0);

        btnAdd.setOnAction(event -> this.addAction());
    }

    private void addAction() {
        String name = txfName.getText().trim();
        if(name.length() > 0){
            names.add(name);
            Controller.addPerson(name);
            lvwNames.getItems().setAll(names);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add name");
            alert.setHeaderText("No name entered");
            alert.setContentText("Enter a name");
            alert.show();
        }
    }

    private ArrayList<String> initNames() {
        names.add("Peter");
        names.add("Søren");
        names.add("Jørgen");
        names.add("Bo");
        names.add("Lasse");
        names.add("Jesper");
        names.add("Henrik");
        names.add("Kasper");
        names.add("Louise");
        return names;
    }

}

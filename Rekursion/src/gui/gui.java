package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class gui extends Application {

    Label count = new Label();
    SierpinskiTrianglePane pane = new SierpinskiTrianglePane();

    @Override
    public void start(Stage primaryStage) {
        AtomicInteger orderCount = new AtomicInteger();
        HBox hBox = new HBox(10);
        Button smaller = new Button("<");
        Button bigger = new Button(">");
        smaller.setOnAction(
                e -> pane.setOrder(orderCount.getAndDecrement()));
        bigger.setOnAction(
                e -> pane.setOrder(orderCount.getAndIncrement()));
        smaller.setAlignment(Pos.BOTTOM_LEFT);
        bigger.setAlignment(Pos.BOTTOM_RIGHT);


        // Pane to hold label, text field, and a button
        hBox.getChildren().add(smaller);
        hBox.getChildren().add(bigger);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 600, 600);
        primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    public EventHandler<ActionEvent> updateLabel() {
        count.setText("Count: " + pane.getOrder());
        return null;
    }
}

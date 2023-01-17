import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

    Slider sliderR = new Slider(0, 255, 1);
    Slider sliderG = new Slider(0, 255, 1);
    Slider sliderB = new Slider(0, 255, 1);

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label R = new Label("R");
        this.sliderR.valueProperty().addListener(
                event -> this.sliderValueChanged(pane));

        Label G = new Label("G");
        this.sliderG.valueProperty().addListener(
                event -> this.sliderValueChanged(pane));

        Label B = new Label("B");
        this.sliderB.valueProperty().addListener(
                event -> this.sliderValueChanged(pane));

        pane.add(R, 0,0);
        pane.add(sliderR, 1,0);

        pane.add(G, 0,1);
        pane.add(sliderG, 1,1);

        pane.add(B, 0,2);
        pane.add(sliderB, 1,2);


    }

    private void sliderValueChanged(GridPane pane) {
        int valueR = (int)this.sliderR.getValue();
        int valueG = (int)this.sliderG.getValue();
        int valueB = (int)this.sliderB.getValue();
        String color = String.format("#%02X%02X%02X", valueR, valueG, valueB);
        pane.setStyle("-fx-background: " + color + ";");
    }

}

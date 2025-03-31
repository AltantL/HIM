package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class PremiereApplication extends Application {

    public void start(Stage stage)   {
//        stage.setTitle("Hello JavaFX");
//        stage.setWidth(400);
//        stage.setHeight(150);
//        stage.centerOnScreen();
//        stage.show();

        VBox root = new VBox(10);

        Label labelHello = new Label("Hello");
        root.getChildren().add(labelHello);
        Label labelHelloBis = new Label("Hello JavaFX");
        root.getChildren().add(labelHelloBis);

        File css = new File("css"+File.separator+"premiersStyle.css");

        Scene scene = new Scene(root, 300, 80);
        stage.setScene (scene);
        stage.setTitle ("Hello JavaFX");
        stage.show();

        scene.getStylesheets().add(css.toURI().toString());

    }

    public static void main(String[] args) {
        Application.launch();
    }

}
package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PremiereApplication extends Application {

    public void start(Stage stage) {

        stage.setTitle("Test");
        VBoxRoot root = new VBoxRoot();
        Scene scene = new Scene(root,400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}

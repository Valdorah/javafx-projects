package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent p = FXMLLoader.load(getClass().getResource("/fxml/mainScene.fxml"));
        Scene s = new Scene(p);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}

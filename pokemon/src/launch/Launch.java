package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent p = FXMLLoader.load(getClass().getResource("/fxml/mainScene.fxml"));
        Scene s = new Scene(p);
        stage.setScene(s);
        stage.setTitle("Pokemon");
        stage.show();
    }
}

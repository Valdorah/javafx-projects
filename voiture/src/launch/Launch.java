package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainScene;

public class Launch extends Application {
    private FXMLLoader loader;
    private MainScene controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.loader = new FXMLLoader(getClass().getResource("/fxml/mainScene.fxml"));
        this.controller = new MainScene();
        this.loader.setController(this.controller);
        Parent p = this.loader.load();
        Scene s = new Scene(p);
        primaryStage.setScene(s);
        primaryStage.setTitle("Mes voitures");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        this.controller.save();
        super.stop();
    }
}

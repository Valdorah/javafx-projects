package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class CouleurUC extends FlowPane {
    @FXML
    private Label codeRGB;
    @FXML
    private  Rectangle overviewColor;

    public Label getCodeRGB() {
        return codeRGB;
    }

    public Rectangle getOverviewColor() {
        return overviewColor;
    }

    public CouleurUC() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(this);
        loader.setRoot(this);
        loader.setLocation(getClass().getResource("/fxml/CouleurUC.fxml"));
        loader.load();
    }
}

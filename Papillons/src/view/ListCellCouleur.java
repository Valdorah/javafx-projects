package view;

import javafx.scene.control.ListCell;
import viewmodel.CouleurVM;

import java.io.IOException;

public class ListCellCouleur extends ListCell<CouleurVM> {
    @Override
    protected void updateItem(CouleurVM item, boolean empty) {
        super.updateItem(item, empty);
        if(empty){
            this.setGraphic(null);
        }
        else{
            try {
                CouleurUC couleurUC = new CouleurUC();
                couleurUC.getOverviewColor().fillProperty().bind(item.colorProperty());
                couleurUC.getCodeRGB().textProperty().bind(item.codeRGBProperty());
                this.setGraphic(couleurUC);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

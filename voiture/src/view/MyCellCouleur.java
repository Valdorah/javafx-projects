package view;

import javafx.scene.control.ListCell;
import viewmodel.CouleurVM;

public class MyCellCouleur extends ListCell<CouleurVM> {
    @Override
    protected void updateItem(CouleurVM item, boolean empty) {
        super.updateItem(item, empty);
        if(empty){
            this.textProperty().unbind();
            this.setText("");
        }
        else{
            this.textProperty().bind(item.codeRGBProperty());
        }
    }
}

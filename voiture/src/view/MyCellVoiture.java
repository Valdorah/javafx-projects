package view;

import javafx.scene.control.ListCell;
import viewmodel.VoitureVM;

public class MyCellVoiture extends ListCell<VoitureVM> {
    @Override
    protected void updateItem(VoitureVM item, boolean empty) {
        super.updateItem(item, empty);
        if(empty){
            this.textProperty().unbind();
            this.setText("");
        }
        else{
            this.textProperty().bind(item.nomProperty());
        }
    }
}

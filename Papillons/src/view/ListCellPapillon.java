package view;

import javafx.scene.control.ListCell;
import viewmodel.PapillonVM;

public class ListCellPapillon extends ListCell<PapillonVM> {
    @Override
    protected void updateItem(PapillonVM item, boolean empty) {
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

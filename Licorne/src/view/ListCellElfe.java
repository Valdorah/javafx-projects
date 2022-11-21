package view;

import javafx.scene.control.ListCell;
import viewmodel.ElfeVM;

public class ListCellElfe extends ListCell<ElfeVM> {
    @Override
    protected void updateItem(ElfeVM item, boolean empty) {
        super.updateItem(item, empty);
        if(empty){
            this.textProperty().unbind();
            this.setText("");
        }else{
            this.textProperty().bind(item.nomProperty());
        }
    }
}

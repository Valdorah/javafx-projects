package view;

import javafx.scene.control.ListCell;
import viewmodel.LicorneVM;

public class ListCellLicorne extends ListCell<LicorneVM> {
    @Override
    protected void updateItem(LicorneVM item, boolean empty) {
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

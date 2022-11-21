package redefine;

import javafx.scene.control.ListCell;
import model.Pokemon;

public class MaCell extends ListCell<Pokemon> {
    @Override
    protected void updateItem(Pokemon item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            this.textProperty().bind(item.nomProperty());
        }
        else{
            this.textProperty().unbind();
            this.setText("");
        }
    }
}

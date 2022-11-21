package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import viewmodel.ElfeVM;
import viewmodel.ForetVM;
import viewmodel.LicorneVM;

public class MainScene {
    private ForetVM foretVM;
    @FXML
    private ListView<ElfeVM> elfes;
    @FXML
    private ListView<LicorneVM> licornes;
    @FXML
    private TextField nomElfe;

    public void initialize(){
        this.foretVM = new ForetVM();
        this.elfes.itemsProperty().bindBidirectional(this.foretVM.elfesProperty());
        this.elfes.setCellFactory(__ -> new ListCellElfe());
        this.licornes.setCellFactory(__ -> new ListCellLicorne());
        this.elfes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue != null){
                this.nomElfe.textProperty().unbindBidirectional(oldValue.nomProperty());
                this.licornes.itemsProperty().unbind();
            }
            if(newValue != null){
                this.nomElfe.textProperty().bindBidirectional(newValue.nomProperty());
                this.licornes.itemsProperty().bind(newValue.licornesProperty());
            }
        });
    }

    public void ajouterElfe() {
        this.foretVM.ajouterElfe();
    }
}

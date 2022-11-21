package view;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import viewmodel.CouleurVM;
import viewmodel.GarageVM;
import viewmodel.VoitureVM;

import java.io.IOException;

public class MainScene {
    private GarageVM garageVM;
    @FXML
    private ListView<VoitureVM> voitures;
    @FXML
    private ListView<CouleurVM> couleurs;
    @FXML
    private TextField nomVoiture;
    @FXML
    private ColorPicker picker;

    public void initialize(){
        try {
            this.garageVM = new GarageVM();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.voitures.itemsProperty().bind(this.garageVM.voituresProperty());
        this.voitures.setCellFactory(__ -> new MyCellVoiture());
        this.couleurs.setCellFactory(__ -> new MyCellCouleur());
        this.voitures.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if(oldValue != null){
                this.nomVoiture.textProperty().unbindBidirectional(oldValue.nomProperty());
            }
            if(newValue != null){
                this.nomVoiture.textProperty().bindBidirectional(newValue.nomProperty());
                this.couleurs.itemsProperty().bind(newValue.couleurProperty());
            }
        });
        this.couleurs.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if(oldValue != null){
                this.picker.valueProperty().unbindBidirectional(oldValue.couleurProperty());
            }
            if(newValue != null){
                this.picker.valueProperty().bindBidirectional(newValue.couleurProperty());
            }
        });
    }

    @FXML
    private void ajouterVoiture() {
        this.garageVM.ajouterVoiture();
    }

    public void save() {
        try {
            this.garageVM.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

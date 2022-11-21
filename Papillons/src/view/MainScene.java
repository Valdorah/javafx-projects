package view;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import stub.Stub;
import viewmodel.CouleurVM;
import viewmodel.ForetVM;
import viewmodel.PapillonVM;

import java.io.IOException;

public class MainScene {
    private ForetVM foretVM;
    @FXML
    private ListView<PapillonVM> foret;
    @FXML
    private ListView<CouleurVM> couleurs;
    @FXML
    private TextField nomPapillon;
    @FXML
    private ColorPicker picker;

    public MainScene() {
        try {
            this.foretVM = new ForetVM();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initialize(){
        this.foret.itemsProperty().bind(this.foretVM.papillonsProperty());
        this.foret.setCellFactory(__ -> new ListCellPapillon());
        this.couleurs.setCellFactory(__ -> new ListCellCouleur());
        this.foret.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if(oldValue != null){
                this.nomPapillon.textProperty().unbindBidirectional(oldValue.nomProperty());
                this.couleurs.itemsProperty().unbind();
            }
            if(newValue != null){
                this.nomPapillon.textProperty().bindBidirectional(newValue.nomProperty());
                this.couleurs.itemsProperty().bind(newValue.couleursProperty());
            }
        });

        this.couleurs.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if(oldValue != null){
                this.picker.valueProperty().unbindBidirectional(oldValue.colorProperty());
            }
            if(newValue != null){
                this.picker.valueProperty().bindBidirectional(newValue.colorProperty());
            }
        });
    }

    @FXML
    private void ajouterPapillon() {
        this.foretVM.ajouterPapillon();
    }

    @FXML
    private void supprimerPapillon(){
        this.couleurs.itemsProperty().unbind();
        this.couleurs.setItems(null);
        this.foretVM.supprimerPapillon(this.foret.getSelectionModel().getSelectedItem());
        this.nomPapillon.setText("");
    }

    @FXML
    private void ajouterCouleur() {
        this.foret.getSelectionModel().getSelectedItem().ajouterCouleur();
    }

    @FXML
    private void supprimerCouleur(){
        this.foret.getSelectionModel().getSelectedItem().supprimerCouleur(this.couleurs.getSelectionModel().getSelectedItem());
    }

    public void save(){
        try {
            this.foretVM.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

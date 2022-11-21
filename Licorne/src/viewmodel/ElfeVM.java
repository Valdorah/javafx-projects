package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Elfe;

public class ElfeVM {
    private Elfe model;

    private StringProperty nom = new SimpleStringProperty();
        public String getNom() { return nom.get(); }
        public StringProperty nomProperty() { return nom; }
        public void setNom(String nom) { this.nom.set(nom); }

    private ObservableList<LicorneVM> licorneObs = FXCollections.observableArrayList();
    private ListProperty<LicorneVM> licornes = new SimpleListProperty<>(licorneObs);
        public ObservableList<LicorneVM> getLicornes() { return licornes.get(); }
        public ListProperty<LicorneVM> licornesProperty() { return licornes; }
        public void setLicornes(ObservableList<LicorneVM> licornes) { this.licornes.set(licornes); }

    public ElfeVM(Elfe model) {
        this.model = model;
        this.setNom(model.getNom());
        model.getLicornes().forEach(licorne -> this.licorneObs.add(new LicorneVM(licorne)));
    }
}

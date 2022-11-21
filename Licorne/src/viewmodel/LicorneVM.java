package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Licorne;

public class LicorneVM {
    private Licorne model;

    private StringProperty nom = new SimpleStringProperty();
        public String getNom() { return nom.get(); }
        public StringProperty nomProperty() { return nom; }
        public void setNom(String nom) { this.nom.set(nom); }

    public LicorneVM(Licorne model) {
        this.model = model;
        this.setNom(model.getNom());
    }
}

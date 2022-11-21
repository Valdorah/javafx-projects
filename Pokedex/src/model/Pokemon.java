package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pokemon {
    private StringProperty nom = new SimpleStringProperty();
        public String getNom() { return nom.getValue(); }
        public StringProperty nomProperty() { return nom; }
        public void setNom(String nom) { this.nom.setValue(nom); }

    public Pokemon(String nom) {
        setNom(nom);
    }

    @Override
    public String toString() {
        return getNom();
    }
}

package modelview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Pokemon;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PokemonVM implements PropertyChangeListener {
    private Pokemon model;
    private StringProperty nom = new SimpleStringProperty();
        public String getNom() { return nom.get(); }
        public StringProperty nomProperty() { return nom; }
        public void setNom(String nom) { this.nom.set(nom); }

    public PokemonVM(Pokemon p) {
        model = p;
        setNom(p.getNom());
        nomProperty().addListener((__, oldValue, newValue) -> {
            model.setNom(newValue);
        });
        model.addListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setNom((String) evt.getNewValue());
    }
}

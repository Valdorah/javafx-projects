package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Voiture;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VoitureVM implements PropertyChangeListener {
    private Voiture model;

    private StringProperty nom = new SimpleStringProperty();
        public String getNom() { return nom.get(); }
        public StringProperty nomProperty() { return nom; }
        private void setNom(String nom) { this.nom.set(nom); }

    private ObservableList<CouleurVM> couleurObs = FXCollections.observableArrayList();
    private ListProperty<CouleurVM> couleur = new SimpleListProperty<>(couleurObs);
        public ObservableList<CouleurVM> getCouleur() { return couleur.get(); }
        public ListProperty<CouleurVM> couleurProperty() { return couleur; }
        public void setCouleur(ObservableList<CouleurVM> couleur) { this.couleur.set(couleur); }

    public VoitureVM(Voiture model) {
        this.model = model;
        this.model.addListener(this);
        this.setNom(model.getNom());
        model.getCouleurs().forEach(couleur -> this.couleurObs.add(new CouleurVM(couleur)));
        this.nomProperty().addListener((__, oldValue, newValue) -> this.model.setNom(this.getNom()));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Voiture.PROP_NOM)){
            this.setNom((String) evt.getNewValue());
        }
    }
}

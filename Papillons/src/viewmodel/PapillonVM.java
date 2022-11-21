package viewmodel;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Couleur;
import model.Papillon;
import stub.Stub;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PapillonVM implements PropertyChangeListener {
    private Papillon model;

    private StringProperty nom = new SimpleStringProperty();
        public String getNom() { return nom.get(); }
        public StringProperty nomProperty() { return nom; }
        public void setNom(String nom) { this.nom.set(nom); }

    private ObservableList<CouleurVM> couleurObs = FXCollections.observableArrayList();
    private SimpleListProperty<CouleurVM> couleurs = new SimpleListProperty<>(couleurObs);
        public ObservableList<CouleurVM> getCouleurs() { return couleurs.get(); }
        public SimpleListProperty<CouleurVM> couleursProperty() { return couleurs; }
        public void setCouleurs(ObservableList<CouleurVM> couleurs) { this.couleurs.set(couleurs); }

    public PapillonVM(Papillon model) {
        this.model = model;
        this.model.ajouterListener(this);
        this.setNom(model.getNom());
        model.getCouleurs().forEach(couleur -> this.couleurObs.add(new CouleurVM(couleur)));
        this.nomProperty().addListener((__, oldValue, newValue) -> {
            this.model.setNom(newValue);
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Papillon.PROP_NOM)){
            this.setNom((String) evt.getNewValue());
        }
        if(evt.getPropertyName().equals(Papillon.PROP_COULEUR)){
            if(evt.getNewValue() != null){
                this.couleurObs.add(new CouleurVM(this.model.getCouleurs().get(((IndexedPropertyChangeEvent) evt).getIndex())));
            }
            if(evt.getOldValue() != null) {
                this.couleurObs.remove(evt.getOldValue());
            }
        }
    }

    public void ajouterCouleur() {
        this.model.ajouterCouleur(Stub.returnWhiteColor());
    }

    public Papillon getModel(){
        return this.model;
    }

    public void supprimerCouleur(CouleurVM c) {
        this.couleurs.remove(c);
        this.model.supprimerCouleur(c.getModel());
    }
}

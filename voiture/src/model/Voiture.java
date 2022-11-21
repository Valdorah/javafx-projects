package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Voiture implements Serializable {
    private transient PropertyChangeSupport support;
    private String nom;
    public static final String PROP_NOM = "nom";
    private List<Couleur> couleurs = new ArrayList<>();
    public static final String PROP_COULEURS = "couleurs";

    public Voiture(String nom) {
        this.support = new PropertyChangeSupport(this);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.getSupport().firePropertyChange(PROP_NOM, this.nom, nom);
        this.nom = nom;
    }

    public List<Couleur> getCouleurs() {
        return Collections.unmodifiableList(this.couleurs);
    }

    public void ajouterCouleur(Couleur c){
        this.couleurs.add(c);
    }

    public void addListener(PropertyChangeListener listener){
        this.getSupport().addPropertyChangeListener(listener);
    }

    public PropertyChangeSupport getSupport(){
        if(this.support == null){
            this.support = new PropertyChangeSupport(this);
        }

        return this.support;
    }

    @Override
    public String toString() {
        return String.format("Voiture {%s}", this.nom);
    }
}

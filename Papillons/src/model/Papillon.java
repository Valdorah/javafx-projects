package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Papillon implements Serializable {
    private transient PropertyChangeSupport support;
    private String nom;
    public static final String PROP_NOM = "nom";
    private List<Couleur> couleurs = new ArrayList<>();
    public static final String PROP_COULEUR = "couleur";

    public Papillon(String nom) {
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
        this.getSupport().fireIndexedPropertyChange(PROP_COULEUR, this.couleurs.size() - 1, null, c);
    }

    public void ajouterListener(PropertyChangeListener listener){
        this.getSupport().addPropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return String.format("Papillon{ %s }", nom);
    }

    private PropertyChangeSupport getSupport(){
        if(this.support == null){
            this.support = new PropertyChangeSupport(this);
        }

        return this.support;
    }

    public void supprimerCouleur(Couleur c) {
        this.getSupport().fireIndexedPropertyChange(PROP_COULEUR, this.couleurs.indexOf(c), c, null);
        this.couleurs.remove(c);
    }
}

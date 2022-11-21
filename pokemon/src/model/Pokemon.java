package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pokemon{
    private String nom;
    public static final String NOM_PROP = "nom";
    private PropertyChangeSupport support;

    public Pokemon(String nom) {
        support = new PropertyChangeSupport(this);
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        support.firePropertyChange(NOM_PROP, this.nom, nom);
        this.nom = nom;
    }

    public void addListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener){
        support.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return nom;
    }
}

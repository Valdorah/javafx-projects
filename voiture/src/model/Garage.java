package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage implements Serializable {
    private transient PropertyChangeSupport support;
    private List<Voiture> voitures = new ArrayList<>();
    public static final String PROP_VOITURE = "voitures";

    public Garage() {
        this.support = new PropertyChangeSupport(this);
    }

    public List<Voiture> getVoitures() {
        return Collections.unmodifiableList(this.voitures);
    }

    public void ajouterVoiture(Voiture v){
        this.voitures.add(v);
        this.getSupport().fireIndexedPropertyChange(PROP_VOITURE, this.voitures.size() - 1, null, v);
    }

    public void addListener(PropertyChangeListener listener){
        this.getSupport().addPropertyChangeListener(listener);
    }

    private PropertyChangeSupport getSupport(){
        if(this.support == null){
            this.support = new PropertyChangeSupport(this);
        }

        return this.support;
    }
}

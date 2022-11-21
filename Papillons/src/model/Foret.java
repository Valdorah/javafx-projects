package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Foret implements Serializable {
    private transient PropertyChangeSupport support = new PropertyChangeSupport(this);
    private List<Papillon> papillons = new ArrayList<>();
    public static final String PROP_PAPILLON = "papillon";

    public List<Papillon> getPapillons() {
        return Collections.unmodifiableList(this.papillons);
    }

    public void ajouterPapillon(Papillon p){
        this.papillons.add(p);
        this.getSupport().fireIndexedPropertyChange(PROP_PAPILLON, this.papillons.size() - 1, null, p);
    }

    public void ajouterListener(PropertyChangeListener listener) {
        this.getSupport().addPropertyChangeListener(listener);
    }

    private PropertyChangeSupport getSupport(){
        if(this.support == null){
            this.support = new PropertyChangeSupport(this);
        }

        return this.support;
    }

    public void supprimerPapillon(Papillon model) {
        this.getSupport().fireIndexedPropertyChange(PROP_PAPILLON, this.papillons.indexOf(model), model, null);
        this.papillons.remove(model);
    }
}

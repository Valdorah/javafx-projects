package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Foret {
    private transient PropertyChangeSupport support;
    private List<Elfe> elfes = new ArrayList<>();
    public static final String PROP_ELFES = "elfes";

    public Foret() {
        this.support = getSupport();
    }

    public List<Elfe> getElfes() {
        return Collections.unmodifiableList(this.elfes);
    }

    public void ajouterElfe(Elfe f){
        this.elfes.add(f);
        this.getSupport().fireIndexedPropertyChange(PROP_ELFES, this.elfes.size() - 1, null, f);
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
}

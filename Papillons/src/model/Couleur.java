package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Couleur implements Serializable {
    private transient PropertyChangeSupport support;
    private int red;
    public static String PROP_RED = "red";
    private int green;
    public static String PROP_GREEN = "green";
    private int blue;
    public static String PROP_BLUE = "blue";

    public Couleur(int red, int green, int blue) {
        this.support = new PropertyChangeSupport(this);
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.getSupport().firePropertyChange(PROP_RED, this.red, red);
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.getSupport().firePropertyChange(PROP_GREEN, this.green, green);
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.getSupport().firePropertyChange(PROP_BLUE, this.blue, blue);
        this.blue = blue;
    }

    public void addListener(PropertyChangeListener listener){
        this.getSupport().addPropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return String.format("Couleur { %d - %d - %d }", this.red, this.green, this.blue);
    }

    public PropertyChangeSupport getSupport(){
        if(this.support == null){
            this.support = new PropertyChangeSupport(this);
        }

        return this.support;
    }
}

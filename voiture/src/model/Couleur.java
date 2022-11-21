package model;

import java.io.Serializable;

public class Couleur implements Serializable {
    private int red;
    private int green;
    private int blue;

    public Couleur(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Override
    public String toString() {
        return String.format("Couleur {%d - %d - %d}", this.red, this.green, this.blue);
    }
}

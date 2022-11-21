package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elfe {
    private String nom;
    private List<Licorne> licornes = new ArrayList<>();

    public Elfe(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Licorne> getLicornes() {
        return Collections.unmodifiableList(this.licornes);
    }

    public void ajouterLicorne(Licorne l){
        this.licornes.add(l);
    }

    @Override
    public String toString() {
        return this.nom;
    }
}

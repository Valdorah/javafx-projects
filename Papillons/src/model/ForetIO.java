package model;

import serialisation.Chargeur;
import serialisation.Sauveur;

import java.io.*;

public class ForetIO implements Sauveur, Chargeur {
    @Override
    public void save(String fichier, Foret foret) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fichier)))){
            oos.writeObject(foret);
        }
    }

    @Override
    public Foret load(String fichier) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fichier)))){
            return (Foret) ois.readObject();
        }
    }
}

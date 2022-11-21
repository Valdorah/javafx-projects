package model;

import serialisation.Chargeur;
import serialisation.Sauveur;

import java.io.*;

public class GarageIO implements Sauveur, Chargeur {
    @Override
    public void save(String path, Garage garage) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)))){
            oos.writeObject(garage);
        }
    }

    @Override
    public Garage load(String fichier) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fichier)))) {
            return (Garage) ois.readObject();
        }
    }
}

package serialisation;

import model.Garage;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Chargeur {
    public Garage load(String fichier) throws IOException, ClassNotFoundException;
}

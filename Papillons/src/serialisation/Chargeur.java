package serialisation;

import model.Foret;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Chargeur {
    public Foret load(String fichier) throws IOException, ClassNotFoundException;
}

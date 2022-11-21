package serialisation;

import model.Foret;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Sauveur {
    public void save(String fichier, Foret foret) throws IOException;
}

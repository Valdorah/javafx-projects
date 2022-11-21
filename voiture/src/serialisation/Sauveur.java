package serialisation;

import model.Garage;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Sauveur {
    public void save(String path, Garage garage) throws IOException;
}

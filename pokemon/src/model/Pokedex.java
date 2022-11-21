package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pokedex {
    private List<Pokemon> pokedex;

    public Pokedex() {
        pokedex = new ArrayList<>();
    }

    public List<Pokemon> getPokedex() {
        return Collections.unmodifiableList(pokedex);
    }

    public void setPokedex(List<Pokemon> pokedex) {
        this.pokedex = pokedex;
    }
}

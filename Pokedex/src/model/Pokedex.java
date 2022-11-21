package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
    private ObservableList<Pokemon> mesPokemons = FXCollections.observableArrayList();
    private ListProperty<Pokemon> pokemons = new SimpleListProperty(mesPokemons);
        public ObservableList<Pokemon> getPokemons() { return pokemons.get(); }
        public ListProperty<Pokemon> pokemonsProperty() { return pokemons; }
        public void setPokemons(ObservableList<Pokemon> pokemons) { this.pokemons.set(pokemons); }

    public void addPokemon(Pokemon p){
        mesPokemons.add(p);
    }
}

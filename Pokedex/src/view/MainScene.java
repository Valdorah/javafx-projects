package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Pokedex;
import model.Pokemon;
import redefine.MaCell;

public class MainScene {
    private Pokedex p = new Pokedex();

    @FXML
    private TextField nomPokemonTf;
    @FXML
    private ListView<Pokemon> maListView;

    public void initialize(){
        maListView.itemsProperty().bind(p.pokemonsProperty());

        maListView.getSelectionModel().selectedItemProperty().addListener((__, oldValue, newValue) -> {
            if(oldValue != null){
                nomPokemonTf.textProperty().unbindBidirectional(oldValue.nomProperty());
            }
            if(newValue != null){
                nomPokemonTf.textProperty().bindBidirectional(newValue.nomProperty());
            }
        });

        maListView.setCellFactory(__ -> new MaCell());
    }

    @FXML
    private void addPokemon() {
        p.addPokemon(new Pokemon("Pikachu"));
    }
}

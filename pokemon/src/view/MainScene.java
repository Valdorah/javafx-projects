package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Pokemon;
import modelview.PokemonVM;

public class MainScene {
    private PokemonVM pokemon;

    @FXML
    private TextField nomPokemon;
    @FXML
    private Label monLabel;

    public void initialize(){
        pokemon = new PokemonVM(new Pokemon("Pikachu"));
        nomPokemon.textProperty().bindBidirectional(pokemon.nomProperty());
        monLabel.textProperty().bind(pokemon.nomProperty());
    }
}

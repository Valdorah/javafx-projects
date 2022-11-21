package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Garage;
import model.GarageIO;
import stub.Stub;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

public class GarageVM implements PropertyChangeListener {
    private GarageIO garageIO;
    private Garage model;

    private ObservableList<VoitureVM> voitureObs = FXCollections.observableArrayList();
    private ListProperty<VoitureVM> voitures = new SimpleListProperty<>(this.voitureObs);
        public ObservableList<VoitureVM> getVoitures() { return voitures.get(); }
        public ListProperty<VoitureVM> voituresProperty() { return voitures; }
        public void setVoitures(ObservableList<VoitureVM> voitures) { this.voitures.set(voitures); }

    public GarageVM() throws IOException, ClassNotFoundException {
        this.garageIO = new GarageIO();
        File f = new File("data.bin");
        if(f.exists()){
            this.model = this.garageIO.load("data.bin");
        }
        else{
            this.model = Stub.getOneGarage();
        }
        this.model.addListener(this);
        model.getVoitures().forEach(voiture -> this.voitureObs.add(new VoitureVM(voiture)));
    }

    public void ajouterVoiture() {
        this.model.ajouterVoiture(Stub.getOneVoiture());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Garage.PROP_VOITURE)){
            this.voitureObs.add(new VoitureVM(this.model.getVoitures().get(((IndexedPropertyChangeEvent) evt).getIndex())));
        }
    }

    public void save() throws IOException {
        this.garageIO.save("data.bin", this.model);
    }
}

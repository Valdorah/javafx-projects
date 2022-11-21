package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Foret;
import stub.Stub;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForetVM implements PropertyChangeListener {
    private Foret model;
    private ObservableList<ElfeVM> elfeObs = FXCollections.observableArrayList();
    private ListProperty<ElfeVM> elfes = new SimpleListProperty<>(elfeObs);
        public ObservableList<ElfeVM> getElfes() { return elfes.get(); }
        public ListProperty<ElfeVM> elfesProperty() { return elfes; }
        public void setElfes(ObservableList<ElfeVM> elfes) { this.elfes.set(elfes); }

    public ForetVM() {
        this.model = Stub.getOneForet();
        this.model.addListener(this);
        model.getElfes().forEach(elfe -> this.elfeObs.add(new ElfeVM(elfe)));
    }

    public void ajouterElfe() {
        this.model.ajouterElfe(Stub.getOneElfe());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.elfeObs.add(new ElfeVM(this.model.getElfes().get(((IndexedPropertyChangeEvent)evt).getIndex())));
    }
}

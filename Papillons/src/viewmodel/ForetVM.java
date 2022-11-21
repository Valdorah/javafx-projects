package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Foret;
import model.ForetIO;
import model.Papillon;
import stub.Stub;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

public class ForetVM implements PropertyChangeListener {
    private Foret model;

    private ObservableList<PapillonVM> papillonsObs = FXCollections.observableArrayList();
    private ListProperty<PapillonVM> papillons = new SimpleListProperty<>(papillonsObs);
        public ObservableList<PapillonVM> getPapillons() { return papillons.get(); }
        public ListProperty<PapillonVM> papillonsProperty() { return papillons; }
        public void setPapillons(ObservableList<PapillonVM> papillons) { this.papillons.set(papillons); }

    public ForetVM() throws IOException, ClassNotFoundException {
        File f = new File("data_2.bin");
        if(f.exists()){
            ForetIO foretIO = new ForetIO();
            this.model = foretIO.load("data_2.bin");
        }
        else{
            // this.model = Stub.getOneForet();
            this.model = new Foret();
        }
        this.model.ajouterListener(this);
        model.getPapillons().forEach(papillon -> this.papillonsObs.add(new PapillonVM(papillon)));
    }

    public void ajouterPapillon() {
        this.model.ajouterPapillon(new Papillon("Petal"));
    }

    public void supprimerPapillon(PapillonVM p) {
        this.papillonsObs.remove(p);
        this.model.supprimerPapillon(p.getModel());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Foret.PROP_PAPILLON)){
            if(evt.getNewValue() != null){
                this.papillonsObs.add(new PapillonVM(this.model.getPapillons().get(((IndexedPropertyChangeEvent) evt).getIndex())));
            }
            if(evt.getOldValue() != null){
                this.papillonsObs.remove(evt.getOldValue());
            }
        }
    }

    public void save() throws IOException {
        ForetIO foretIO = new ForetIO();
        foretIO.save("data_2.bin", this.model);
    }
}

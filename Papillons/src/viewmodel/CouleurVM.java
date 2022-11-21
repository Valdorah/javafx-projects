package viewmodel;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import model.Couleur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CouleurVM implements PropertyChangeListener {
    private Couleur model;

    private StringProperty codeRGB = new SimpleStringProperty();
        public String getCodeRGB() { return codeRGB.get(); }
        public StringProperty codeRGBProperty() { return codeRGB; }
        private void setCodeRGB(String codeRGB) { this.codeRGB.set(codeRGB); }

    private IntegerProperty red = new SimpleIntegerProperty();
        public int getRed() { return red.get(); }
        public IntegerProperty redProperty() { return red; }
        private void setRed(int red) { this.red.set(red); }

    private IntegerProperty green = new SimpleIntegerProperty();
        public int getGreen() { return green.get(); }
        public IntegerProperty greenProperty() { return green; }
        private void setGreen(int green) { this.green.set(green); }

    private IntegerProperty blue = new SimpleIntegerProperty();
        public int getBlue() { return blue.get(); }
        public IntegerProperty blueProperty() { return blue; }
        private void setBlue(int blue) { this.blue.set(blue); }

    Property<Color> color = new SimpleObjectProperty<>();
        public Color getColor() { return color.getValue(); }
        public Property<Color> colorProperty() { return color; }
        private void setColor(Color color) { this.color.setValue(color); }

    public CouleurVM(Couleur model) {
        this.model = model;
        this.setRed(model.getRed());
        this.setGreen(model.getGreen());
        this.setBlue(model.getBlue());
        this.setColor(Color.rgb(this.getRed(), this.getGreen(), this.getBlue()));
        this.setCodeRGB(String.format("%d - %d - %d", this.getRed(), this.getGreen(), this.getBlue()));

        this.color.addListener((__, oldValue, newValue) -> {
            this.model.setRed((int) (newValue.getRed() * 255.0));
            this.setRed((int) (newValue.getRed() * 255.0));
            this.model.setGreen((int) (newValue.getGreen() * 255.0));
            this.setGreen((int) (newValue.getGreen() * 255.0));
            this.model.setBlue((int) (newValue.getBlue() * 255.0));
            this.setBlue((int) (newValue.getBlue() * 255.0));
            this.setCodeRGB(String.format("%d - %d - %d", this.getRed(), this.getGreen(), this.getBlue()));
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals(Couleur.PROP_RED)){
            this.setRed((int) evt.getNewValue());
        }
        if(evt.getPropertyName().equals(Couleur.PROP_GREEN)){
            this.setGreen((int) evt.getNewValue());
        }
        if(evt.getPropertyName().equals(Couleur.PROP_BLUE)){
            this.setBlue((int) evt.getNewValue());
        }
    }

    public Couleur getModel(){
            return this.model;
    }
}

package stub;

import model.Couleur;
import model.Garage;
import model.Voiture;

public class Stub {
    public static Garage getOneGarage(){
        Garage g = new Garage();
        Voiture v1 = new Voiture("Choupette");
        Voiture v2 = new Voiture("Pimpon");

        v1.ajouterCouleur(new Couleur(255, 0, 0));
        v2.ajouterCouleur(new Couleur(0,255, 0));
        g.ajouterVoiture(v1);
        g.ajouterVoiture(v2);

        return g;
    }

    public static Voiture getOneVoiture(){
        return new Voiture("Taco");
    }
}

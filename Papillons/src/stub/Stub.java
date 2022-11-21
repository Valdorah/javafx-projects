package stub;

import model.Couleur;
import model.Foret;
import model.Papillon;

public class Stub {
    public static Foret getOneForet(){
        Foret f = new Foret();
        Papillon p1 = new Papillon("Floey");
        Papillon p2 = new Papillon("Fly");
        Couleur c1 = new Couleur(255, 0, 0);
        Couleur c2 = new Couleur(255, 255, 0);
        p1.ajouterCouleur(c1);
        p2.ajouterCouleur(c2);
        f.ajouterPapillon(p1);
        f.ajouterPapillon(p2);
        return f;
    }

    public static Couleur returnWhiteColor(){
        return new Couleur(0, 0, 0);
    }
}

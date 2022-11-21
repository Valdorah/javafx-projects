package stub;

import model.Elfe;
import model.Foret;
import model.Licorne;

public class Stub {
    public static Foret getOneForet(){
        Foret f = new Foret();
        Elfe e1 = new Elfe("Eragon");
        Elfe e2 = new Elfe("Ayra");
        Licorne l1 = new Licorne("Toto");
        Licorne l2 = new Licorne("Tata");
        e1.ajouterLicorne(l1);
        e2.ajouterLicorne(l2);
        f.ajouterElfe(e1);
        f.ajouterElfe(e2);
        return f;
    }

    public static Elfe getOneElfe() {
        return new Elfe("Noëla");
    }
}

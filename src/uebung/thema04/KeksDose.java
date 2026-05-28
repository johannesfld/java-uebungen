package uebung.thema04;

import java.util.ArrayList;

public class KeksDose extends ArrayList<Keks> {

    private static final long serialVersionUID = 1L;

    public int gesamtEnergie() {
        int summe = 0;
        for (Keks k : this) {
            summe += k.getEnergieKeks();
        }
        return summe;
    }
}

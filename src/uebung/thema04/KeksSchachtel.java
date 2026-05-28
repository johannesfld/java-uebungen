package uebung.thema04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeksSchachtel {

    private final List<Keks> kekse = new ArrayList<>();
    private final int maxEnergie;

    public KeksSchachtel() {
        this(Integer.MAX_VALUE);
    }

    public KeksSchachtel(int maxEnergie) {
        this.maxEnergie = maxEnergie;
    }

    public boolean add(Keks k) {
        if (gesamtEnergie() + k.getEnergieKeks() > maxEnergie) {
            return false;
        }
        return kekse.add(k);
    }

    public int gesamtEnergie() {
        int summe = 0;
        for (Keks k : kekse) {
            summe += k.getEnergieKeks();
        }
        return summe;
    }

    public int size() {
        return kekse.size();
    }

    public List<Keks> getKekse() {
        return Collections.unmodifiableList(kekse);
    }
}

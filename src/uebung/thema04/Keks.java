package uebung.thema04;

public class Keks {

    private final int energieKeks;

    public Keks(int energieKeks) {
        this.energieKeks = energieKeks;
    }

    public int getEnergieKeks() {
        return energieKeks;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + getEnergieKeks() + " kcal)";
    }
}

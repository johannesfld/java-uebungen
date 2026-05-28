package uebung.thema04;

public class GlasierterKeks extends Keks {

    private final int energieGlasur;

    public GlasierterKeks(int energieKeks, int energieGlasur) {
        super(energieKeks);
        this.energieGlasur = energieGlasur;
    }

    @Override
    public int getEnergieKeks() {
        return super.getEnergieKeks() + energieGlasur;
    }
}

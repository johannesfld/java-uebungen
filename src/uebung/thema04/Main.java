package uebung.thema04;

public class Main {

    public static void main(String[] args) {
        KeksDose dose = new KeksDose();
        dose.add(new Keks(80));
        dose.add(new Keks(95));
        dose.add(new GlasierterKeks(80, 30));
        dose.add(new GlasierterKeks(95, 45));
        dose.add(new Keks(60));

        System.out.println("KeksDose (Vererbung von ArrayList):");
        for (Keks k : dose) {
            System.out.println("  " + k);
        }
        System.out.println("  Gesamtenergie: " + dose.gesamtEnergie() + " kcal");

        KeksSchachtel schachtel = new KeksSchachtel();
        schachtel.add(new Keks(80));
        schachtel.add(new Keks(95));
        schachtel.add(new GlasierterKeks(80, 30));
        schachtel.add(new GlasierterKeks(95, 45));
        schachtel.add(new Keks(60));

        System.out.println("KeksSchachtel (Delegation):");
        for (Keks k : schachtel.getKekse()) {
            System.out.println("  " + k);
        }
        System.out.println("  Gesamtenergie: " + schachtel.gesamtEnergie() + " kcal");

        System.out.println();
        System.out.println("Variante mit oberer Energiegrenze (max 300 kcal):");
        KeksSchachtel begrenzt = new KeksSchachtel(300);
        Keks[] kandidaten = {
                new Keks(80),
                new Keks(95),
                new GlasierterKeks(80, 30),
                new GlasierterKeks(95, 45),
                new Keks(60)
        };
        for (Keks k : kandidaten) {
            boolean ok = begrenzt.add(k);
            System.out.println("  add(" + k + ") -> " + (ok ? "OK" : "abgelehnt (Grenze)"));
        }
        System.out.println("  Endstand: " + begrenzt.size() + " Kekse, "
                + begrenzt.gesamtEnergie() + " kcal");

        System.out.println();
        System.out.println("Bei einer oberen Energiegrenze ist die Delegation (KeksSchachtel)");
        System.out.println("zu bevorzugen: add() kann die Grenze pruefen. Bei Vererbung von");
        System.out.println("ArrayList koennte ein Aufrufer ueber addAll/add(int,E) die Pruefung");
        System.out.println("umgehen, ohne dass die KeksDose das mitbekommt.");
    }
}

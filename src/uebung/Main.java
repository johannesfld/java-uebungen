package uebung;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            runAll();
            return;
        }
        String[] rest = new String[args.length - 1];
        System.arraycopy(args, 1, rest, 0, rest.length);
        switch (args[0].toLowerCase()) {
            case "thema01": uebung.thema01.Main.main(rest); break;
            case "thema02": uebung.thema02.Main.main(rest); break;
            case "thema03": uebung.thema03.Main.main(rest); break;
            case "thema04": uebung.thema04.Main.main(rest); break;
            case "thema05": uebung.thema05.Main.main(rest); break;
            default:
                System.out.println("Unbekanntes Thema: " + args[0]);
                System.out.println("Erlaubt: thema01 .. thema05  (oder ohne Argument fuer alle)");
        }
    }

    private static void runAll() {
        trenner("Thema 01 - Quersumme");
        uebung.thema01.Main.main(new String[0]);
        trenner("Thema 02 - Person");
        uebung.thema02.Main.main(new String[0]);
        trenner("Thema 03 - NotNull");
        uebung.thema03.Main.main(new String[0]);
        trenner("Thema 04 - Keks");
        uebung.thema04.Main.main(new String[0]);
        trenner("Thema 05 - ArrayList vs LinkedList");
        uebung.thema05.Main.main(new String[0]);
    }

    private static void trenner(String titel) {
        System.out.println();
        System.out.println("=== " + titel + " ===");
    }
}

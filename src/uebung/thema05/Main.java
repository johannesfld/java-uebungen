package uebung.thema05;

public class Main {

    public static void main(String[] args) {
        int n = 500_000;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Ungueltige Zahl, nehme 500000.");
            }
        }
        // Achtung: bei grossem n koennen die LinkedList-Index-Operationen lange dauern
        new ListenPerformance(n).runAll();
    }
}

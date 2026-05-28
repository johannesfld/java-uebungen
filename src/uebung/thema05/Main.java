package uebung.thema05;

public class Main {

    public static void main(String[] args) {
        int n = 500_000;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Ungueltige Zahl, nutze Default 500000.");
            }
        }
        System.out.println("Hinweis: LinkedList-Index-Zugriffe (Zeilen 3 und 5) sind O(n^2)");
        System.out.println("und koennen bei n=500000 mehrere Minuten dauern.");
        System.out.println();
        new ListenPerformance(n).runAll();
    }
}

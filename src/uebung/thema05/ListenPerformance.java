package uebung.thema05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListenPerformance {

    private final int n;

    public ListenPerformance(int n) {
        this.n = n;
    }

    public void runAll() {
        System.out.println("n = " + n);
        System.out.printf("%-50s %12s %12s%n", "Operation", "ArrayList", "LinkedList");

        zeile("anfuegen von n Elementen am Ende",
                anfuegenEnde(new ArrayList<>()), anfuegenEnde(new LinkedList<>()));

        zeile("einschieben von n Elementen am Anfang",
                einschiebenAnfang(new ArrayList<>()), einschiebenAnfang(new LinkedList<>()));

        zeile("Zugriff per Index (get(i))",
                zugriffIndex(gefuellt(new ArrayList<>())), zugriffIndex(gefuellt(new LinkedList<>())));

        zeile("Zugriff per Iterator",
                zugriffIterator(gefuellt(new ArrayList<>())), zugriffIterator(gefuellt(new LinkedList<>())));

        zeile("erstes Element n-mal loeschen per Index",
                loeschenIndex(gefuellt(new ArrayList<>())), loeschenIndex(gefuellt(new LinkedList<>())));

        zeile("erstes Element n-mal loeschen per Iterator",
                loeschenIterator(gefuellt(new ArrayList<>())), loeschenIterator(gefuellt(new LinkedList<>())));

        zeile("100000 ab Index 1000 einzeln einfuegen",
                einfuegenEinzeln(new ArrayList<>()), einfuegenEinzeln(new LinkedList<>()));

        zeile("100000 ab Index 1000 als Collection einfuegen",
                einfuegenCollection(new ArrayList<>()), einfuegenCollection(new LinkedList<>()));
    }

    private void zeile(String titel, long arrayListZeit, long linkedListZeit) {
        System.out.printf("%-50s %9d ms %9d ms%n", titel, arrayListZeit, linkedListZeit);
    }

    // fuellt die Liste mit n Zahlen und gibt sie zurueck, damit der Aufbau
    // nicht in die Messung reinrechnet
    private List<Integer> gefuellt(List<Integer> liste) {
        for (int i = 0; i < n; i++) {
            liste.add(i);
        }
        return liste;
    }

    private long anfuegenEnde(List<Integer> liste) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            liste.add(i);
        }
        return System.currentTimeMillis() - start;
    }

    private long einschiebenAnfang(List<Integer> liste) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            liste.add(0, i);
        }
        return System.currentTimeMillis() - start;
    }

    private long zugriffIndex(List<Integer> liste) {
        long start = System.currentTimeMillis();
        long summe = 0;
        for (int i = 0; i < liste.size(); i++) {
            summe += liste.get(i);
        }
        return System.currentTimeMillis() - start;
    }

    private long zugriffIterator(List<Integer> liste) {
        long start = System.currentTimeMillis();
        long summe = 0;
        for (int i : liste) {
            summe += i;
        }
        return System.currentTimeMillis() - start;
    }

    private long loeschenIndex(List<Integer> liste) {
        long start = System.currentTimeMillis();
        while (!liste.isEmpty()) {
            liste.remove(0);
        }
        return System.currentTimeMillis() - start;
    }

    private long loeschenIterator(List<Integer> liste) {
        long start = System.currentTimeMillis();
        Iterator<Integer> it = liste.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        return System.currentTimeMillis() - start;
    }

    private long einfuegenEinzeln(List<Integer> liste) {
        for (int i = 0; i < 400_000; i++) {
            liste.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            liste.add(1000 + i, -1);
        }
        return System.currentTimeMillis() - start;
    }

    private long einfuegenCollection(List<Integer> liste) {
        for (int i = 0; i < 400_000; i++) {
            liste.add(i);
        }
        List<Integer> einzufuegen = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            einzufuegen.add(-1);
        }
        long start = System.currentTimeMillis();
        liste.addAll(1000, einzufuegen);
        return System.currentTimeMillis() - start;
    }
}

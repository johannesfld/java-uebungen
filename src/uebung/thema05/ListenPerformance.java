package uebung.thema05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class ListenPerformance {

    private final int n;

    public ListenPerformance(int n) {
        this.n = n;
    }

    public void runAll() {
        System.out.println("n = " + n);
        System.out.printf("%-58s %12s %12s%n", "Operation", "ArrayList", "LinkedList");
        System.out.println("-".repeat(86));

        zeile("anfuegen von n Elementen am Ende",
                () -> messung(this::anfuegenEnde, new ArrayList<>()),
                () -> messung(this::anfuegenEnde, new LinkedList<>()));

        zeile("einschieben von n Elementen am Anfang",
                () -> messung(this::einschiebenAnfang, new ArrayList<>()),
                () -> messung(this::einschiebenAnfang, new LinkedList<>()));

        zeile("sequentieller Zugriff per Index (get(i))",
                () -> messungMitInhalt(this::zugriffIndex, new ArrayList<>()),
                () -> messungMitInhalt(this::zugriffIndex, new LinkedList<>()));

        zeile("sequentieller Zugriff per Iterator",
                () -> messungMitInhalt(this::zugriffIterator, new ArrayList<>()),
                () -> messungMitInhalt(this::zugriffIterator, new LinkedList<>()));

        zeile("n-mal erstes Element loeschen per Index",
                () -> messungMitInhalt(this::loeschenIndex, new ArrayList<>()),
                () -> messungMitInhalt(this::loeschenIndex, new LinkedList<>()));

        zeile("n-mal erstes Element loeschen per Iterator",
                () -> messungMitInhalt(this::loeschenIterator, new ArrayList<>()),
                () -> messungMitInhalt(this::loeschenIterator, new LinkedList<>()));

        zeile("400 000 + 100 000 ab Index 1000 einzeln",
                () -> einfuegenEinzeln(new ArrayList<>()),
                () -> einfuegenEinzeln(new LinkedList<>()));

        zeile("400 000 + 100 000 ab Index 1000 als Collection",
                () -> einfuegenCollection(new ArrayList<>()),
                () -> einfuegenCollection(new LinkedList<>()));
    }

    private void zeile(String titel, Supplier<Long> arrayListZeit, Supplier<Long> linkedListZeit) {
        long a = arrayListZeit.get();
        long l = linkedListZeit.get();
        System.out.printf("%-58s %10d ms %10d ms%n", titel, a, l);
    }

    private long messung(java.util.function.Consumer<List<Integer>> aktion, List<Integer> liste) {
        long start = System.currentTimeMillis();
        aktion.accept(liste);
        return System.currentTimeMillis() - start;
    }

    private long messungMitInhalt(java.util.function.Consumer<List<Integer>> aktion, List<Integer> liste) {
        fuelle(liste);
        long start = System.currentTimeMillis();
        aktion.accept(liste);
        return System.currentTimeMillis() - start;
    }

    private void fuelle(List<Integer> liste) {
        for (int i = 0; i < n; i++) {
            liste.add(i);
        }
    }

    private void anfuegenEnde(List<Integer> liste) {
        for (int i = 0; i < n; i++) {
            liste.add(i);
        }
    }

    private void einschiebenAnfang(List<Integer> liste) {
        for (int i = 0; i < n; i++) {
            liste.add(0, i);
        }
    }

    private void zugriffIndex(List<Integer> liste) {
        long summe = 0;
        for (int i = 0; i < liste.size(); i++) {
            summe += liste.get(i);
        }
        if (summe == Long.MIN_VALUE) System.out.println(summe);
    }

    private void zugriffIterator(List<Integer> liste) {
        long summe = 0;
        for (Integer i : liste) {
            summe += i;
        }
        if (summe == Long.MIN_VALUE) System.out.println(summe);
    }

    private void loeschenIndex(List<Integer> liste) {
        while (!liste.isEmpty()) {
            liste.remove(0);
        }
    }

    private void loeschenIterator(List<Integer> liste) {
        Iterator<Integer> it = liste.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
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
        List<Integer> einzufuegen = new ArrayList<>(100_000);
        for (int i = 0; i < 100_000; i++) {
            einzufuegen.add(-1);
        }
        long start = System.currentTimeMillis();
        liste.addAll(1000, einzufuegen);
        return System.currentTimeMillis() - start;
    }
}

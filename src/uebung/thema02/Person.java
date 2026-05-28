package uebung.thema02;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {

    private static final DateTimeFormatter DATUM = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final String name;
    private final LocalDate gebDat;

    public Person(String name, LocalDate gebDat) {
        this.name = name;
        this.gebDat = gebDat;
    }

    public String getName() {
        return name;
    }

    public LocalDate getGebDat() {
        return gebDat;
    }

    public boolean geburtstag() {
        MonthDay heute = MonthDay.from(LocalDate.now());
        MonthDay geburtstag = MonthDay.from(gebDat);
        return heute.isBefore(geburtstag);
    }

    public int alter() {
        return Period.between(gebDat, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        String hinweis = geburtstag() ? "Geburtstag kommt noch" : "Geburtstag schon gehabt";
        return name + " (geb. " + gebDat.format(DATUM) + ", " + alter() + " Jahre, " + hinweis + ")";
    }
}

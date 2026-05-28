package uebung.thema02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LocalDate heute = LocalDate.now();

        List<Person> personen = new ArrayList<>();
        personen.add(new Person("Anna Albrecht", LocalDate.of(1992, 3, 14)));
        personen.add(new Person("Ben Becker", LocalDate.of(1985, 11, 27)));
        personen.add(new Person("Clara Conrad", heute.minusYears(30)));
        personen.add(new Person("David Diehl", heute.plusDays(1).minusYears(25)));
        personen.add(new Person("Eva Ebert", heute.minusDays(1).minusYears(40)));

        for (Person p : personen) {
            System.out.println(p);
        }
    }
}

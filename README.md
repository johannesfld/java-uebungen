# Java-Übungen (DHSN Prüfungsleistung 20%)

Lösungen zur jeweils ersten Aufgabe der fünf Übungsthemen.

## Voraussetzungen

- Java 11 oder höher (kein Maven erforderlich)

## Bauen und Starten (Windows)

```powershell
.\build.ps1
java -jar uebungen.jar
```

## Manuell bauen (Linux/Mac)

```bash
find src -name "*.java" > sources.txt
javac -encoding UTF-8 -d out @sources.txt
jar cfe uebungen.jar uebung.Main -C out .
java -jar uebungen.jar
```

## Ausführung

```
java -jar uebungen.jar             # alle fünf Themen nacheinander
java -jar uebungen.jar thema01     # nur Quersumme
java -jar uebungen.jar thema02     # nur Person
java -jar uebungen.jar thema03     # nur NotNull
java -jar uebungen.jar thema04     # nur Keks
java -jar uebungen.jar thema05     # nur Listen-Performance
java -jar uebungen.jar thema05 50000   # mit kleinerem n
```

## Paketstruktur

| Package | Aufgabe |
|---|---|
| `uebung.thema01` | Quersumme einer positiven Zahl (`long` + `BigInteger` für sehr große Zahlen) |
| `uebung.thema02` | Klasse `Person` mit `geburtstag()` und `alter()`, Ausgabe einer `ArrayList<Person>` |
| `uebung.thema03` | Generische Methode `NotNull.notNull(T... args)` |
| `uebung.thema04` | Keks-Hierarchie als `KeksDose` (Vererbung von `ArrayList`) und `KeksSchachtel` (Delegation) |
| `uebung.thema05` | Laufzeit-Vergleich `ArrayList` vs `LinkedList` bei n = 500 000 |

Jedes Package enthält eine Klasse `Main`, die das Ergebnis demonstriert.

## Hinweis zu Thema 05

Die Aufgabe verlangt n = 500 000. Bei `LinkedList` sind die Operationen
"Zugriff per Index" und "Löschen erstes Element per Index" jeweils O(n²) — das
sind ~2,5 · 10¹¹ Schritte und dauert mehrere Minuten bis Stunden. Genau dieser
Effekt ist der Lerninhalt der Aufgabe. Für eine schnelle Demo kann ein
kleineres n als Argument übergeben werden, z. B. `java -jar uebungen.jar thema05 50000`.

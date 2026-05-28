package uebung.thema01;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Quersumme q = new Quersumme();

        long[] tests = { 0L, 7L, 12345L, 123456789L, Long.MAX_VALUE };
        for (long n : tests) {
            System.out.println("quersumme(" + n + ") = " + q.quersumme(n));
        }

        BigInteger grosseZahl = new BigInteger(
                "12345678901234567890123456789012345678901234567890" +
                "98765432109876543210987654321098765432109876543210");
        System.out.println("quersumme(" + grosseZahl + ")");
        System.out.println("  = " + q.quersumme(grosseZahl));
    }
}

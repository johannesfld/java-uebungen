package uebung.thema01;

import java.math.BigInteger;

public class Quersumme {

    public long quersumme(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Zahl muss positiv sein: " + n);
        }
        long summe = 0;
        while (n > 0) {
            summe += n % 10;
            n /= 10;
        }
        return summe;
    }

    public int quersumme(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("Zahl muss positiv sein: " + n);
        }
        int summe = 0;
        for (char c : n.toString().toCharArray()) {
            summe += c - '0';
        }
        return summe;
    }
}

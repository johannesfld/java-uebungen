package uebung.thema03;

public class Main {

    public static void main(String[] args) {
        System.out.println(NotNull.notNull("abc", null, "xyz"));
        System.out.println(NotNull.notNull(null, 123, null));
        System.out.println(NotNull.<Object>notNull());
        System.out.println(NotNull.<Object>notNull(null, null, null));
        System.out.println(NotNull.notNull(null, null, 3.14, "spaeter"));
    }
}

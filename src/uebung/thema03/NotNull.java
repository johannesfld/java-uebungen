package uebung.thema03;

public final class NotNull {

    private NotNull() {
    }

    @SafeVarargs
    public static <T> T notNull(T... args) {
        if (args == null) {
            return null;
        }
        for (T a : args) {
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}

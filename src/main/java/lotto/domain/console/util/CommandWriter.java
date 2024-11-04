package lotto.domain.console.util;

public final class CommandWriter {
    public static void write(final String message) {
        System.out.println(message);
    }

    public static void writeFormat(String message, Object... args) {
        write(String.format(message, args));
    }
}

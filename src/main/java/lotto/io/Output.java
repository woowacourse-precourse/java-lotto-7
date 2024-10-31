package lotto.io;

public final class Output {
    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printlnFormattedMessage(String format, Object... args) {
        System.out.printf((format) + "%n", args);
    }
}

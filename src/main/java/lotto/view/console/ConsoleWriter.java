package lotto.view.console;

public final class ConsoleWriter {
    public static void printlnMessage(String message) {
        System.out.println(message);
    }

    public static void printlnMessageWithEmptyLine(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}

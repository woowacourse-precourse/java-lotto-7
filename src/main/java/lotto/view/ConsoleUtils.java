package lotto.view;

public class ConsoleUtils {

    public static void printMessageWithNewLine(String message) {
        System.out.println(message);
    }

    public static void printFormattedMessage(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}

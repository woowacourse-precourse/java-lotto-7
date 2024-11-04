package lotto.view;

public class OutputView {

    private OutputView() {
        throw new IllegalStateException("OutputView is utility class");
    }

    public static void printMessageWithNewLine(String message) {
        printMessage(message);
        printNewLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
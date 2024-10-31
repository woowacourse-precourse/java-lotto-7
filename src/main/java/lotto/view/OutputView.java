package lotto.view;

public class OutputView {
    private static final String ERROR = "[ERROR] ";

    public static void errorPrint(String errorMessage) {
        System.out.println(ERROR + errorMessage);
    }

    public static void printPrompt(String string) {
        System.out.println(string);
    }
}

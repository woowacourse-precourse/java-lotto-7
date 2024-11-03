package lotto.view;

public class OutputView {
    private static final String ERROR_HEADER = "[ERROR]";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + " " + errorMessage);
    }
}

package lotto.view;

public class OutputView {

    private final static String ERROR_PREFIX = "[ERROR] ";

    public static void printError(IllegalArgumentException exception) {
        System.out.println(ERROR_PREFIX + exception.getMessage());
    }
}

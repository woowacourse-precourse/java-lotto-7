package lotto.view;

public class ErrorView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printError(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }
}

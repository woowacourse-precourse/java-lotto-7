package lotto.view;

public class OutputView {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printError(String errorMessageContent) {
        System.out.println(ERROR_MESSAGE_PREFIX + errorMessageContent);
    }
}

package lotto.view;

public class ErrorView {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    protected ErrorView() {
    }

    public static void announceError(Exception exception) {
        System.out.println(ERROR_MESSAGE_PREFIX + exception.getMessage());
    }
}

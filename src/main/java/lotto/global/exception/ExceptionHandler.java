package lotto.global.exception;

public class ExceptionHandler {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static ExceptionHandler instance;

    private ExceptionHandler() {}

    public static ExceptionHandler getInstance() {
        if (instance == null) {
            instance = new ExceptionHandler();
        }
        return instance;
    }

    public static String createErrorMessage(String message) {
        return ERROR_PREFIX + message;
    }

}

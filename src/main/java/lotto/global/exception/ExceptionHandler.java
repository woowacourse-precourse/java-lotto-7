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

    public IllegalArgumentException handleException(Exception e) {
        return new IllegalArgumentException(createErrorMessage(e));
    }

    private String createErrorMessage(Exception e) {
        return ERROR_PREFIX + e.getMessage();
    }
}

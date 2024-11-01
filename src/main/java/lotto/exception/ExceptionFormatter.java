package lotto.exception;

public class ExceptionFormatter {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";

    public String format(RuntimeException exception) {
        return EXCEPTION_FORMAT.formatted(exception.getMessage());
    }
}

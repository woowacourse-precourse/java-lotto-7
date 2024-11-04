package lotto.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public CustomIllegalArgumentException(final String message) {
        super(ERROR_PREFIX + message);
    }
}

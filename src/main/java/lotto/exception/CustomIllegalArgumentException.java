package lotto.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    public CustomIllegalArgumentException(final String message) {
        super(ERROR_MESSAGE + message);
    }
}

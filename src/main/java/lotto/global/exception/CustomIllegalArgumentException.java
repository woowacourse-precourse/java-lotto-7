package lotto.global.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    public CustomIllegalArgumentException(String message) {
        super(MESSAGE_PREFIX + message);
    }
}

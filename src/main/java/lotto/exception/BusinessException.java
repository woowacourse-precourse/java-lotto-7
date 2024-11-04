package lotto.exception;

public class BusinessException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public BusinessException(ErrorMessage message) {
        super(ERROR_MESSAGE_PREFIX + message);
    }
}

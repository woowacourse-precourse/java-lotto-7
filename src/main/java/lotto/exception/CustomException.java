package lotto.exception;

public class CustomException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public CustomException(ExceptionMessage exceptionMessage) {
        super(ERROR_MESSAGE_PREFIX + exceptionMessage.getMessage());
    }
}

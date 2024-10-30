package lotto.exception.common;

public abstract class BaseException extends IllegalArgumentException {

    private final static String EXCEPTION_MESSAGE_PREFIX = "[ERROR] %s";

    public BaseException(ExceptionMessage message) {
        super(String.format(EXCEPTION_MESSAGE_PREFIX, message.getMessage()));
    }

}

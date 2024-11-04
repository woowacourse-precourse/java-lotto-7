package lotto.exception;

public abstract class BaseException extends IllegalArgumentException {
    public BaseException(String message) {
        super(message);
    }

    public abstract BaseExceptionType exceptionType();
}
package lotto.exception;

public abstract class BaseException extends IllegalArgumentException {

    public BaseException() {
    }

    public abstract BaseExceptionType exceptionType();
}
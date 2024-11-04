package lotto.exception;

public class MoneyException extends BaseException {
    private final MoneyExceptionType exceptionType;

    public MoneyException(MoneyExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
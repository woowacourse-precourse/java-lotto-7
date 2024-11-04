package lotto.exception;

public class MoneyException extends BaseException {
    private final MoneyExceptionType exceptionType;

    public MoneyException(MoneyExceptionType exceptionType) {
        super(exceptionType.errorMessage());
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
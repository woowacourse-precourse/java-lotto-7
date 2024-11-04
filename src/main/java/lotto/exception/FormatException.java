package lotto.exception;

public class FormatException extends BaseException {
    private final FormatExceptionType exceptionType;

    public FormatException(FormatExceptionType exceptionType) {
        super(exceptionType.errorMessage());
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}


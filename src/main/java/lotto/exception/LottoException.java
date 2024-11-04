package lotto.exception;

public class LottoException extends BaseException {
    private final LottoExceptionType exceptionType;

    public LottoException(LottoExceptionType exceptionType) {
        super(exceptionType.errorMessage());
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
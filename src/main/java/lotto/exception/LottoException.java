package lotto.exception;

public class LottoException extends BaseException {
    private final LottoExceptionType exceptionType;

    public LottoException(LottoExceptionType exceptionType){
        this.exceptionType = exceptionType;
    }
    @Override
    public BaseExceptionType exceptionType() {
        return exceptionType;
    }
}
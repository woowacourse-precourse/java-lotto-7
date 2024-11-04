package lotto.exception;

public class LottoException extends RuntimeException{
    public LottoException(final ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
    }
}

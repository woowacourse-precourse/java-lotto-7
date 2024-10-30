package lotto.exception;

public class LottoException extends IllegalArgumentException {

    public LottoException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
    }
}

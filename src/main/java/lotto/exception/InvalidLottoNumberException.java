package lotto.exception;

public class InvalidLottoNumberException extends GeneralException {
    public InvalidLottoNumberException(final ErrorType errorType) {
        super(errorType);
    }
}

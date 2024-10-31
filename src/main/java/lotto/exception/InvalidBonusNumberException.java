package lotto.exception;

public class InvalidBonusNumberException extends GeneralException {
    public InvalidBonusNumberException(final ErrorType errorType) {
        super(errorType);
    }
}

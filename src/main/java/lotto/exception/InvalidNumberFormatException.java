package lotto.exception;

public class InvalidNumberFormatException extends GeneralException {
    public InvalidNumberFormatException(final ErrorType errorType) {
        super(errorType);
    }
}

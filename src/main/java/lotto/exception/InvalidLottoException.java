package lotto.exception;

public class InvalidLottoException extends IllegalArgumentException {
    public InvalidLottoException(ExceptionMessage message) {
        super(message.getMessage());
    }
}

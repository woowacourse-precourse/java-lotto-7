package lotto.exception;

public class LottoValidationException extends IllegalArgumentException {
    public LottoValidationException(ExceptionMessage message) {
        super(message.getMessage());
    }

    public LottoValidationException(ExceptionMessage message, Throwable cause) {
        super(message.getMessage(), cause);
    }
}

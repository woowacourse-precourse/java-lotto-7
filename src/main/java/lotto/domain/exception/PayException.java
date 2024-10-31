package lotto.domain.exception;

public class PayException extends IllegalArgumentException {

    public PayException(final PayExceptionMessage message) {
        super(message.getErrorMessage());
    }
}

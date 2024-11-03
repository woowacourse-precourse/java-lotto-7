package lotto.exception;

public class MaxRetryExceededException extends IllegalStateException {
    public MaxRetryExceededException(ErrorMessages errorMessages) {
        super(errorMessages.getMessage());
    }
}

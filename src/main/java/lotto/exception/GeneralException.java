package lotto.exception;

public class GeneralException extends RuntimeException {

    private final ErrorType errorType;

    public GeneralException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}

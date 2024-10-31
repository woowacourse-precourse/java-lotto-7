package lotto.error;

public abstract class AppException extends IllegalArgumentException {

    protected AppException(final String errorType) {
        super(errorType);
    }

}

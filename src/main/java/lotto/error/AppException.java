package lotto.error;

public abstract class AppException extends IllegalArgumentException {

    public static final String PREFIX = "[ERROR] ";

    protected AppException(final String errorType) {
        super(PREFIX + errorType);
    }

}

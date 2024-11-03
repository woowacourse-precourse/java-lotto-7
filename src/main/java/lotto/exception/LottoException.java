package lotto.exception;

public abstract class LottoException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";

    protected LottoException(String message) {
        super(ERROR_PREFIX + message);
    }
}

package lotto.exception;

public abstract class LottoException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public LottoException(String message) {
        super(ERROR_PREFIX + message);
    }
}

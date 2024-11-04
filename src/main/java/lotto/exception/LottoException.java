package lotto.exception;

public class LottoException extends IllegalArgumentException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public LottoException(final String message) {
        super(ERROR_PREFIX + message);
    }
}

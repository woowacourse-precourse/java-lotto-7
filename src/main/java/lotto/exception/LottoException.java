package lotto.exception;

public class LottoException extends RuntimeException {
    public static final String ERROR_PREFIX = "[ERROR] ";

    public LottoException(String message) {
        super(ERROR_PREFIX + message);
    }
}

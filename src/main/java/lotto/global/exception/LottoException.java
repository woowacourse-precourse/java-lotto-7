package lotto.global.exception;

public class LottoException extends IllegalArgumentException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public LottoException(ErrorMessage message) {
        super(ERROR_PREFIX + message);
    }
}

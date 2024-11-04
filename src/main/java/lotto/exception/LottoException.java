package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private LottoException(ErrorMessage message) {
        super(ERROR_PREFIX + message.getMessage());
    }

    public static LottoException from(ErrorMessage message) {
        return new LottoException(message);
    }
}

package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    public LottoException(ErrorMessage message) {
        super(PREFIX + message.getMessage());
    }

    public LottoException(String message) {
        super(PREFIX + message);
    }
}

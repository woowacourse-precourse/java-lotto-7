package lotto.exception;

public class LottoArgumentException extends IllegalArgumentException {

    private static final String PREFIX = "[ERROR] ";

    public LottoArgumentException(final String message) {
        super(PREFIX + message);
    }
}

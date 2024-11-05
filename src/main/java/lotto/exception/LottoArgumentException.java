package lotto.exception;

public class LottoArgumentException extends IllegalArgumentException {
    private static final String ERROR_FORMAT = "[ERROR] %s";

    public LottoArgumentException(final String message) {
        super(String.format(ERROR_FORMAT, message));
    }
}

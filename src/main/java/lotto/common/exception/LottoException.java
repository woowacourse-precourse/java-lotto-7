package lotto.common.exception;

public class LottoException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private final String errorMessage;

    public LottoException(String message) {
        super(ERROR_MESSAGE_HEADER + message);
        this.errorMessage = ERROR_MESSAGE_HEADER + message;
    }

    public LottoException(String message, Exception e) {
        super(ERROR_MESSAGE_HEADER + message, e);
        this.errorMessage = ERROR_MESSAGE_HEADER + message;
    }
}

package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private static final String ERROR = "[ERROR] ";
    private final ErrorMessage errorMessage;

    public LottoException (ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public String makeErrorMessage() {
        return ERROR+errorMessage.getMessage();
    }
}

package lotto.exception;

public class LottoException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public LottoException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}

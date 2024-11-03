package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(ErrorMessages errorMessages) {
        super(errorMessages.getMessage());
    }
}

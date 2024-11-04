package lotto.utils;

public class LottoException extends IllegalArgumentException {
    public LottoException(String message) {
        super(message);
    }

    public LottoException(ErrorMessages errorMessages) {
        super(errorMessages.getMessage());
    }
}

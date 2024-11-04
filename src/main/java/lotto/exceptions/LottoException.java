package lotto.exceptions;

public abstract class LottoException extends IllegalArgumentException {
    public LottoException(String message) {
        super(message);
    }

    public abstract String getErrorMessage();
}

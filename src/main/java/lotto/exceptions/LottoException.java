package lotto.exceptions;

public abstract class LottoException extends RuntimeException {
    public LottoException(String message) {
        super(message);
    }

    public abstract String getErrorMessage();
}

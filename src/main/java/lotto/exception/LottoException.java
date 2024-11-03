package lotto.exception;

public class LottoException extends IllegalArgumentException {

    private LottoException(final ErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }

    public static LottoException from(final ErrorMessage errorMessage) {
        return new LottoException(errorMessage);
    }
}

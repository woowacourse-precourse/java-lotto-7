package lotto.domain.exception;

public class LottoException extends IllegalArgumentException {

    public LottoException(final LottoNumberExceptionMessage message) {
        super(message.getErrorMessage());
    }
}

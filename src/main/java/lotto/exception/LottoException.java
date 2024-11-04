package lotto.exception;

public class LottoException extends ApplicationException {

    public LottoException(LottoError error) {
        super(error);
    }

}

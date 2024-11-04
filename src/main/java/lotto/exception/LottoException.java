package lotto.exception;

public class LottoException extends IllegalArgumentException {

    public LottoException(LottoErrorMessage lottoErrorMessage) {
        super(lottoErrorMessage.getMessage());
    }
}

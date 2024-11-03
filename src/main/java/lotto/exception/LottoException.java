package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(LottoErrorStatus lottoErrorStatus) {
        super(lottoErrorStatus.getMessage());
    }
}

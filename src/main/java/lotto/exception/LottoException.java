package lotto.exception;

public class LottoException extends RuntimeException {
    public LottoException(LottoExceptionCode code) {
        super("[ERROR] "+ code.getMessage());
    }
}

package lotto.exception;

public class LottoException extends RuntimeException {
    private LottoExceptionCode code;
    public LottoException(LottoExceptionCode code) {
        super("[ERROR] "+ code.getMessage());
        this.code = code;
    }
    public LottoExceptionCode getCode() {
        return this.code;
    }
}

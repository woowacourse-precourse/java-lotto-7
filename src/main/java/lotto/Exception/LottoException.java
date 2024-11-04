package lotto.Exception;

public class LottoException extends IllegalArgumentException {
    public LottoException(LottoExceptionType messageType) {
        super(messageType.getMessage());
    }
}

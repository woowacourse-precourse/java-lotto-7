package lotto.common.exception;

public class LottoException extends IllegalArgumentException {
    
    public LottoException(ErrorMessage message) {
        super(String.valueOf(message));
    }
}

package lotto.Exception;

public class BonusNumberException extends IllegalArgumentException {
    public BonusNumberException(LottoExceptionType messageType) {
        super(messageType.getMessage());
    }
}

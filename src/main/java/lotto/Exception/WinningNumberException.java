package lotto.Exception;

public class WinningNumberException extends IllegalArgumentException {
    public WinningNumberException(LottoExceptionType messageType) {
        super(messageType.getMessage());
    }
}
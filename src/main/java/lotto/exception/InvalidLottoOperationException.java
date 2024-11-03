package lotto.exception;

public class InvalidLottoOperationException extends IllegalStateException {
    public InvalidLottoOperationException(String message) {
        super("[ERROR] " + message);
    }
}
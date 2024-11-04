package lotto.exception;

public class UninitializedWinningNumbersException extends IllegalStateException {
    public UninitializedWinningNumbersException(String message) {
        super("[ERROR] " + message);
    }
}
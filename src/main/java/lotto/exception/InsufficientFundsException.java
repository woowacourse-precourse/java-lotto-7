package lotto.exception;

public class InsufficientFundsException extends IllegalStateException {
    public InsufficientFundsException(String message) {
        super("[ERROR] " + message);
    }
}
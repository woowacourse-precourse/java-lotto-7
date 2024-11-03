package lotto.exception;

public class InvalidPurchaseAmountException extends IllegalArgumentException {
    public InvalidPurchaseAmountException(String message) {
        super("[ERROR] " + message);
    }
}
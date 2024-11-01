package lotto.io.exception;

public class InputException extends IllegalArgumentException {
    private InputException(final String message) {
        super(message);
    }

    public static InputException invalidPurchaseAmount(String message) {
        throw new InputException(message);
    }
}

package lotto.exception;

public class InvalidPurchasePriceException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    public InvalidPurchasePriceException(final String s) {
        super(ERROR_MESSAGE + s);
    }
}

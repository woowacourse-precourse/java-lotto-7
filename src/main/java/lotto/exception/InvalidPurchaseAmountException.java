package lotto.exception;

public class InvalidPurchaseAmountException extends NumberFormatException {
	public InvalidPurchaseAmountException(String message) {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue() + message);
	}
}

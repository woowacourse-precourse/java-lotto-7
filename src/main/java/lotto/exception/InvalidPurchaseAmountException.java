package lotto.exception;

public class InvalidPurchaseAmountException extends NumberFormatException {
	public InvalidPurchaseAmountException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.INVALID_PURCHASE_AMOUNT);
	}
}

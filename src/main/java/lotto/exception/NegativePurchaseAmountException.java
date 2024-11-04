package lotto.exception;

public class NegativePurchaseAmountException extends IllegalArgumentException {
	public NegativePurchaseAmountException(String message) {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue() + message);
	}
}

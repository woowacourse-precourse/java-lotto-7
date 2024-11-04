package lotto.exception;

public class MaxPurchaseExceedException extends IllegalStateException {
	public MaxPurchaseExceedException(String message) {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue() + message);
	}
}
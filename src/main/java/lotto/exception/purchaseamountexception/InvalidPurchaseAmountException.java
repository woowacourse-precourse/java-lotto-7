package lotto.exception.purchaseamountexception;

import lotto.exception.ErrorConstants;
import lotto.exception.ErrorMessage;

public class InvalidPurchaseAmountException extends NumberFormatException {
	public InvalidPurchaseAmountException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
	}
}

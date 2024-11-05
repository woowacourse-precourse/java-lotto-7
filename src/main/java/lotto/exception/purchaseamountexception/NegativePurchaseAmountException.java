package lotto.exception.purchaseamountexception;

import lotto.exception.ErrorConstants;
import lotto.exception.ErrorMessage;

public class NegativePurchaseAmountException extends IllegalArgumentException {
	public NegativePurchaseAmountException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
	}
}

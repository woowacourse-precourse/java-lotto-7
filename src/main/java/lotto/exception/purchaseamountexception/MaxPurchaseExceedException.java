package lotto.exception.purchaseamountexception;

import lotto.exception.ErrorConstants;
import lotto.exception.ErrorMessage;

public class MaxPurchaseExceedException extends IllegalStateException {
	public MaxPurchaseExceedException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.MAX_PURCHASE_EXCEED.getMessage());
	}
}
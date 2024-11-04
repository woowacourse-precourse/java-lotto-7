package lotto.exception.numberexception;

import lotto.exception.ErrorConstants;
import lotto.exception.ErrorMessage;

public class OutOfRangeNumberException extends IllegalArgumentException {
	public OutOfRangeNumberException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
	}
}

package lotto.exception.numberexception;

import lotto.exception.ErrorConstants;
import lotto.exception.ErrorMessage;

public class InvalidNumberException extends NumberFormatException {
	public InvalidNumberException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
	}
}

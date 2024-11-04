package lotto.exception.winningnumberexception;

import lotto.exception.ErrorConstants;
import lotto.exception.ErrorMessage;

public class OutOfRangeWinningNumberException extends IllegalArgumentException {
	public OutOfRangeWinningNumberException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.OUT_OF_RANGE_WINNING_NUMBER.getMessage());
	}
}

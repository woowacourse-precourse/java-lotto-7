package lotto.exception.lottoticketexception;

import lotto.exception.ErrorConstants;
import lotto.exception.ErrorMessage;

public class DuplicateException extends IllegalArgumentException {
	public DuplicateException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.DUPLICATE_NUMBER.getMessage());
	}
}

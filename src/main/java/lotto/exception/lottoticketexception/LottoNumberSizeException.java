package lotto.exception.lottoticketexception;

import lotto.exception.ErrorConstants;
import lotto.exception.ErrorMessage;

public class LottoNumberSizeException extends IllegalArgumentException {
	public LottoNumberSizeException() {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT.getMessage());
	}
}

package lotto.exception;

import static lotto.constant.LottoErrorMessages.INVALID_INPUT_FORMAT;

public class InvalidInputFormatException extends LottoException {
    public InvalidInputFormatException() {
        super(INVALID_INPUT_FORMAT);
    }
}

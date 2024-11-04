package lotto.global.exception;

import lotto.global.enums.ExceptionMessage;

public class InvalidLottoNumberFormatException extends IllegalArgumentException {
    public InvalidLottoNumberFormatException() {
        super(ExceptionMessage.INVALID_LOTTO_NUMBER_FORMAT.getMessage());
    }
}

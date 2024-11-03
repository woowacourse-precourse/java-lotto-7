package lotto.global.exception;

import lotto.global.enums.ExceptionMessage;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {
    public InvalidLottoNumberRangeException() {
        super(ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}

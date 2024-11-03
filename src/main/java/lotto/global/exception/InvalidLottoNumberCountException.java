package lotto.global.exception;

import lotto.global.enums.ExceptionMessage;

public class InvalidLottoNumberCountException extends IllegalArgumentException {
    public InvalidLottoNumberCountException() {
        super(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }
}

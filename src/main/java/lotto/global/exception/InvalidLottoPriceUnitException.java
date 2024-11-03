package lotto.global.exception;

import lotto.global.enums.ExceptionMessage;

public class InvalidLottoPriceUnitException extends IllegalArgumentException {
    public InvalidLottoPriceUnitException() {
        super(ExceptionMessage.INVALID_LOTTO_PRICE_UNIT.getMessage());
    }
}

package lotto.global.exception;

import lotto.global.enums.ExceptionMessage;

public class InvalidLottoPriceException extends IllegalArgumentException {
    public InvalidLottoPriceException() {
        super(ExceptionMessage.INVALID_LOTTO_PRICE.getMessage());
    }
}

package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class InvalidPriceValueException extends IllegalArgumentException {
    public InvalidPriceValueException() {
        super(LottoErrorMessage.LOTTO_PRICE_ERROR);
    }
}

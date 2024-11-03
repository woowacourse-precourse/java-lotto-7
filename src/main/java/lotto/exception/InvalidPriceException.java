package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class InvalidPriceException extends IllegalArgumentException {
    public InvalidPriceException() {
        super(LottoErrorMessage.ERROR_PRICE_ERROR);
    }
}

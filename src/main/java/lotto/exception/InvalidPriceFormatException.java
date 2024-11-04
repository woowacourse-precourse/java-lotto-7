package lotto.exception;

import lotto.constant.LottoErrorMessage;

public class InvalidPriceFormatException extends IllegalArgumentException {
    public InvalidPriceFormatException() {
        super(LottoErrorMessage.LOTTO_PRICE_FORMAT_ERROR);
    }
}

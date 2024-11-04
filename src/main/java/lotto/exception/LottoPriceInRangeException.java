package lotto.exception;

import static lotto.constant.ExceptionMessageConstants.LOTTO_PRICE_IN_RANGE_ERROR;

public class LottoPriceInRangeException extends  IllegalArgumentBaseException {

    public LottoPriceInRangeException() {
        super(LOTTO_PRICE_IN_RANGE_ERROR.getMessage());
    }
}

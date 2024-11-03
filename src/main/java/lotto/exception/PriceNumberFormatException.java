package lotto.exception;

import static lotto.constant.ExceptionMessageConstants.PRICE_NUMBER_FORMAT_ERROR;

public class PriceNumberFormatException extends  IllegalArgumentBaseException {

    public PriceNumberFormatException() {
        super(PRICE_NUMBER_FORMAT_ERROR.getMessage());
    }
}

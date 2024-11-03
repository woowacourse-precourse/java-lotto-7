package lotto.exception.lottoPrice;

import static lotto.exception.lottoPrice.Constants.INVALID_UNIT_PRICE_MESSAGE;

public class InvalidThousandUnitException extends IllegalArgumentException {
    public InvalidThousandUnitException() {
        super(INVALID_UNIT_PRICE_MESSAGE);
    }
}

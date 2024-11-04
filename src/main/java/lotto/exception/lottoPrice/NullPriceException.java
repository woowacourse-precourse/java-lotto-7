package lotto.exception.lottoPrice;

import static lotto.exception.lottoPrice.Constants.NULL_PRICE_MESSAGE;

public class NullPriceException extends IllegalArgumentException {
    public NullPriceException() {
        super(NULL_PRICE_MESSAGE);
    }
}

package lotto.exception.lottoPrice;

import static lotto.exception.lottoPrice.Constants.MINIMUM_PRICE_MESSAGE;

public class MinimumPriceException extends IllegalArgumentException {
    public MinimumPriceException() {
        super(MINIMUM_PRICE_MESSAGE);
    }
}

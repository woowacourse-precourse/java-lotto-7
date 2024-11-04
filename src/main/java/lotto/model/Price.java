package lotto.model;

import static lotto.constant.LottoConstants.LOTTO_PRICE;
import static lotto.constant.LottoConstants.PURCHASE_LIMIT;
import static lotto.constant.LottoConstants.ZERO;

import lotto.exception.ExactChangeNotPossibleException;
import lotto.exception.LottoPriceInRangeException;

public final class Price {
    private final Integer price;

    public Price(Integer price) {
        validatePriceInRange(price);
        validateExactChangePossible(price);
        this.price = price;
    }

    public int calculateLottoTicketCount() {
        return price / LOTTO_PRICE;
    }

    public Integer getPrice() {
        return price;
    }

    private void validatePriceInRange(Integer price) {
        if (!isPriceInRange(price)) {
            throw new LottoPriceInRangeException();
        }
    }

    private boolean isPriceInRange(Integer price) {
        return price > ZERO && price <= PURCHASE_LIMIT;
    }

    private void validateExactChangePossible(Integer price) {
        if (!isExactChangePossible(price)) {
            throw new ExactChangeNotPossibleException();
        }
    }

    private boolean isExactChangePossible(Integer price) {
        return price % LOTTO_PRICE == ZERO;
    }
}

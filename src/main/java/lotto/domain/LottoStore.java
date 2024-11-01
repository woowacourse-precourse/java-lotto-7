package lotto.domain;

import static lotto.exception.ExceptionMessage.INVALID_PURCHASING_PRICE;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASING_UNIT;

public class LottoStore {
    private static final Money TICKET_PRICE = Money.won(1000);
    private static final Money MAXIMUM_PURCHASE_PRICE = Money.won(100000);

    public int calculateLottoTicket(Money money) {
        validatePurchasingUnit(money);
        validateMaximumPurchasePrice(money);
        return money.divide(TICKET_PRICE)
                .intValue();
    }

    private void validatePurchasingUnit(Money money) {
        if (money.isNotMultipleOf(TICKET_PRICE)) {
            throw new IllegalArgumentException(INVALID_PURCHASING_UNIT.getMessage(TICKET_PRICE.intValue()));
        }
    }

    private void validateMaximumPurchasePrice(Money money) {
        if (money.isGreaterThan(MAXIMUM_PURCHASE_PRICE)) {
            throw new IllegalArgumentException(INVALID_PURCHASING_PRICE.getMessage(MAXIMUM_PURCHASE_PRICE.intValue()));
        }
    }
}

package lotto.domain;

import static lotto.exception.ExceptionMessage.INVALID_PURCHASING_PRICE;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASING_UNIT;

public class LottoStore {

    public static final Money TICKET_PRICE = Money.from(1000);
    public static final Money MAXIMUM_PURCHASE_PRICE = Money.from(100000);

    public int calculateLottoQuantity(Money money) {
        validatePurchasingUnit(money);
        validateMaximumPurchasePrice(money);
        return money.divide(TICKET_PRICE)
                .intValue();
    }

    private void validatePurchasingUnit(Money money) {
        if (money.isNotMultipleOf(TICKET_PRICE)) {
            throw new IllegalArgumentException(INVALID_PURCHASING_UNIT.getMessage());
        }
    }

    private void validateMaximumPurchasePrice(Money money) {
        if (money.isGreaterThan(MAXIMUM_PURCHASE_PRICE)) {
            throw new IllegalArgumentException(INVALID_PURCHASING_PRICE.getMessage());
        }
    }
}

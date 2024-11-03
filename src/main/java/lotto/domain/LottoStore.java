package lotto.domain;

import static lotto.domain.constant.LottoRule.MAXIMUM_PURCHASE_PRICE;
import static lotto.domain.constant.LottoRule.TICKET_PRICE;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASING_PRICE;
import static lotto.exception.ExceptionMessage.INVALID_PURCHASING_UNIT;

public class LottoStore {

    public int calculateLottoQuantity(Money money) {
        validateMinimumPurchasePrice(money);
        validateMaximumPurchasePrice(money);
        validatePurchasingUnit(money);
        return money.divide(Money.from(TICKET_PRICE.getNumber()))
                .intValue();
    }

    private void validatePurchasingUnit(Money money) {
        if (money.isNotMultipleOf(Money.from(TICKET_PRICE.getNumber()))) {
            throw new IllegalArgumentException(INVALID_PURCHASING_UNIT.getMessage());
        }
    }

    private void validateMinimumPurchasePrice(Money money) {
        if (money.isLessThan(Money.from(TICKET_PRICE.getNumber()))) {
            throw new IllegalArgumentException(INVALID_PURCHASING_PRICE.getMessage());
        }
    }

    private void validateMaximumPurchasePrice(Money money) {
        if (money.isGreaterThan(Money.from(MAXIMUM_PURCHASE_PRICE.getNumber()))) {
            throw new IllegalArgumentException(INVALID_PURCHASING_PRICE.getMessage());
        }
    }
}

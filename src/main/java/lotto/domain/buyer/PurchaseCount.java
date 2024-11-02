package lotto.domain.buyer;

import static lotto.resources.Constants.THOUSND_UNIT;
import static lotto.resources.ErrorMessages.INVALID_THOUSAND_UNIT_MONEY;
import static lotto.resources.ErrorMessages.NEGATIVE_QUANTITY_MONEY;

public class PurchaseCount {
    private final int purchaseCount;

    private PurchaseCount(final int money) {
        validateMoney(money);
        this.purchaseCount = money / THOUSND_UNIT;
    }

    public static PurchaseCount from(final int money) {
        return new PurchaseCount(money);
    }

    private void validateMoney(final int money) {
        validatePositiveMoney(money);
        validateThousandUnitMoney(money);
    }

    private void validatePositiveMoney(final int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_QUANTITY_MONEY.getMessage());
        }
    }

    private void validateThousandUnitMoney(final int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_THOUSAND_UNIT_MONEY.getMessage());
        }
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}

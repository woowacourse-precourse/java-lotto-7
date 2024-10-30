package lotto.model;

import static lotto.model.LottoConstants.LOTTO_PRICE;
import static lotto.model.LottoConstants.MAX_LOTTO_PURCHASE_AMOUNT;
import static lotto.model.LottoConstants.MIN_LOTTO_PURCHASE_AMOUNT;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int calculateLottoCount() {
        return amount / LOTTO_PRICE;
    }

    private void validate(final int amount) {
        checkDivisibilityByUnit(amount);
        checkMinimumOfAmount(amount);
        checkMaximumOfAmount(amount);
    }

    private void checkDivisibilityByUnit(final int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private void checkMinimumOfAmount(final int amount) {
        if (amount < MIN_LOTTO_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최소 1,000원 이상이여야 합니다.");
        }
    }

    private void checkMaximumOfAmount(final int amount) {
        if (amount > MAX_LOTTO_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 최대 100,000원 이하여야 합니다.");
        }
    }
}

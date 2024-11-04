package lotto.model;

import static lotto.model.LottoConstants.LOTTO_PRICE;
import static lotto.model.LottoConstants.MAX_LOTTO_PURCHASE_AMOUNT;
import static lotto.model.LottoConstants.MIN_LOTTO_PURCHASE_AMOUNT;

import lotto.exception.LottoValidationError;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(final int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int calculateLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int value() {
        return amount;
    }

    private void validate(final int amount) {
        checkDivisibilityByUnit(amount);
        checkMinimumOfAmount(amount);
        checkMaximumOfAmount(amount);
    }

    private void checkDivisibilityByUnit(final int amount) {
        if (amount % LOTTO_PRICE != 0) {
            LottoValidationError.INVALID_PURCHASE_AMOUNT_UNIT.throwException(LOTTO_PRICE);
        }
    }

    private void checkMinimumOfAmount(final int amount) {
        if (amount < MIN_LOTTO_PURCHASE_AMOUNT) {
            LottoValidationError.PURCHASE_AMOUNT_BELOW_MINIMUM.throwException(MIN_LOTTO_PURCHASE_AMOUNT);
        }
    }

    private void checkMaximumOfAmount(final int amount) {
        if (amount > MAX_LOTTO_PURCHASE_AMOUNT) {
            LottoValidationError.PURCHASE_AMOUNT_ABOVE_MAXIMUM.throwException(MAX_LOTTO_PURCHASE_AMOUNT);
        }
    }
}

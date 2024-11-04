package lotto.model;

import lotto.utils.ErrorMessages;
import lotto.utils.LottoException;

public class PurchaseAmount {
    private static final long MIN_UNIT_PRICE = 1_000;
    private long amount;

    public PurchaseAmount(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        if (amount < 0) {
            throw new LottoException(ErrorMessages.PURCHASE_AMOUNT_LESS_THAN_ZERO);
        }
        if (amount % MIN_UNIT_PRICE != 0) {
            throw new LottoException(ErrorMessages.PURCHASE_AMOUNT_NOT_MINIMUM_UNIT);
        }
    }

    public long getAmount() {
        return amount;
    }

    public int getBuyCount() {
        return (int) (amount / MIN_UNIT_PRICE);
    }
}

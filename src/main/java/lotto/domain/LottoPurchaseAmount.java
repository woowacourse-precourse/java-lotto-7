package lotto.domain;

import static lotto.constant.LottoConstants.PRICE_PER_LOTTO;

import lotto.exception.InvalidPurchaseAmountException;

public class LottoPurchaseAmount {
    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoPurchaseCount() {
        return amount / PRICE_PER_LOTTO.getValue();
    }

    private void validate(int amount) {
        if (amount < PRICE_PER_LOTTO.getValue() || amount % PRICE_PER_LOTTO.getValue() != 0) {
            throw new InvalidPurchaseAmountException();
        }
    }
}

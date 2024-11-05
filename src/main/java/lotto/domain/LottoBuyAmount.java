package lotto.domain;

import static lotto.constant.LottoConstants.PRICE_PER_LOTTO;

import lotto.exception.InvalidBuyAmountException;

public class LottoBuyAmount {
    private final int amount;

    public LottoBuyAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getLottoBuyCount() {
        return amount / PRICE_PER_LOTTO;
    }

    private void validate(int amount) {
        if (amount < PRICE_PER_LOTTO || amount % PRICE_PER_LOTTO != 0) {
            throw new InvalidBuyAmountException();
        }
    }
}

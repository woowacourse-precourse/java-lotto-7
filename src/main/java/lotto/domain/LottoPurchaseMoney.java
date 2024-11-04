package lotto.domain;

import lotto.validator.MoneyValidator;

public class LottoPurchaseMoney {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public LottoPurchaseMoney(String input) {
        long parsedAmount = Long.parseLong(input);
        MoneyValidator.validate(parsedAmount);
        this.amount = (int) parsedAmount;
    }

    public int calculateLottoCount() {
        return this.amount / LOTTO_PRICE;
    }
}

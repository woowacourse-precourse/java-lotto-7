package lotto.domain;

import static lotto.util.LottoConstants.LOTTO_PRICE;

import lotto.validator.MoneyValidator;

public class LottoPurchaseMoney {

    private final int amount;

    public LottoPurchaseMoney(String input) {
        long parsedAmount = Long.parseLong(input);
        MoneyValidator.validate(parsedAmount);
        this.amount = (int) parsedAmount;
    }

    public int calculateLottoCount() {
        return this.amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return this.amount;
    }
}

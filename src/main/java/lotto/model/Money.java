package lotto.model;

import static lotto.constant.ErrorMessage.INVALID_LOTTO_MONEY_UNIT;
import static lotto.constant.LottoInfo.LOTTO_PRICE;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_LOTTO_MONEY_UNIT.getMessage());
        }
    }

    public int toLottoCount() {
        return this.money / LOTTO_PRICE;
    }

    public double getEarningRate(Money earned) {
        return (double) earned.money / this.money * 100;
    }
}

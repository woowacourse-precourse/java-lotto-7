package lotto.domain;

import static lotto.message.ErrorMessage.ERROR_LOTTO_PURCHASE_MONEY_POSITIVE;
import static lotto.message.ErrorMessage.ERROR_LOTTO_PURCHASE_MONEY_UNIT;

public class LottoPurchaseMoney {

    private static final int LOTTO_MONEY_UNIT = 1000;

    private final long money;
    private final long count;

    public LottoPurchaseMoney(long money) {
        validate(money);
        this.money = money;
        this.count = money / LOTTO_MONEY_UNIT;
    }

    public long getMoney() {
        return money;
    }

    public long getCount() {
        return count;
    }

    private void validate(long money) {
        validatePostive(money);
        validateUnit(money);
    }

    private void validatePostive(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ERROR_LOTTO_PURCHASE_MONEY_POSITIVE.message());
        }
    }

    private void validateUnit(long money) {
        if (money % LOTTO_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_LOTTO_PURCHASE_MONEY_UNIT.message());
        }
    }
}

package lotto.domain;

import static lotto.message.ErrorMessage.INVALID_MIN_PURCHASE_MONEY;
import static lotto.message.ErrorMessage.INVALID_UNIT_PURCHASE_MONEY;

public class LottoPurchaseMoney {

    private static final int LOTTO_MONEY_UNIT = 1000;
    private static final int MIN_LOTTO_PURCHASE_MONEY = 0;

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
        validateMinMoney(money);
        validateUnitMoney(money);
    }

    private void validateUnitMoney(long money) {
        if (money % LOTTO_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_PURCHASE_MONEY.message());
        }
    }

    private void validateMinMoney(long money) {
        if (money <= MIN_LOTTO_PURCHASE_MONEY) {
            throw new IllegalArgumentException(INVALID_MIN_PURCHASE_MONEY.message());
        }
    }
}

package lotto.domain;

import static lotto.message.ErrorMessage.INVALID_PURCHASE_MONEY;
import static lotto.message.ErrorMessage.INVALID_UNIT_PURCHASE_MONEY;

public class LottoPurchaseMoney {

    private static final int LOTTO_MONEY_UNIT = 1000;
    private static final int MIN_LOTTO_PURCHASE_MONEY = 0;

    private final long money;

    public LottoPurchaseMoney(long money) {
        validate(money);
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public long getCount() {
        return money / LOTTO_MONEY_UNIT;
    }

    private void validate(long money) {
        validateMinMoney(money);
        validateUnitMoney(money);
    }

    private static void validateUnitMoney(long money) {
        if (money % LOTTO_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_PURCHASE_MONEY.getMessage());
        }
    }

    private static void validateMinMoney(long money) {
        if (money <= MIN_LOTTO_PURCHASE_MONEY) {
            throw new IllegalArgumentException(INVALID_PURCHASE_MONEY.getMessage());
        }
    }
}

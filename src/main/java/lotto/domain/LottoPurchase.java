package lotto.domain;

import static lotto.message.ErrorMessage.INVALID_PURCHASE_MONEY;

public class LottoPurchase {

    private static final int LOTTO_PRICE_UNIT = 1000;

    private final long money;
    private final long count;

    public LottoPurchase(long money) {
        validate(money);
        this.money = money;
        this.count = money / LOTTO_PRICE_UNIT;
    }

    public long getMoney() {
        return money;
    }

    public long getCount() {
        return count;
    }

    private void validate(long money) {
        if (money % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_MONEY.getMessage());
        }
    }
}

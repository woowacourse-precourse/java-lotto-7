package lotto.domain;

import static lotto.message.ErrorMessage.INVALID_PURCHASE_MONEY;

public class LottoPurchaseMoney {

    private static final int LOTTO_PRICE_UNIT = 1000;

    private final long money;
    private final long lottoCount;

    public LottoPurchaseMoney(long money) {
        validate(money);
        this.money = money;
        this.lottoCount = money / LOTTO_PRICE_UNIT;
    }

    private void validate(long money) {
        if (money % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_MONEY.getMessage());
        }
    }

    public long getLottoCount() {
        return lottoCount;
    }
}

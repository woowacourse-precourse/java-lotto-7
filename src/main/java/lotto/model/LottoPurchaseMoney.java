package lotto.model;

import static lotto.constant.ErrorMessage.GET_SOME_MONEY;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_PURCHASE_MONEY;
import static lotto.constant.LottoInfo.LOTTO_PRICE;

public class LottoPurchaseMoney extends Money {
    public LottoPurchaseMoney(final int money) {
        super(money);
        validate(money);
    }

    private void validate(final int money) {
        if (money == 0) {
            throw new IllegalArgumentException(GET_SOME_MONEY.getMessage());
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_MONEY.getMessage());
        }
    }

    public int toLottoCount() {
        return this.money / LOTTO_PRICE;
    }
}

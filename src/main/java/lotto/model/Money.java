package lotto.model;

import static lotto.constant.ErrorMessage.*;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private final Integer money;

    public Money(Integer money) {
        validationPurchaseMoneyMinumum(money);

        validationPurchaseMoneyDivisibility(money);
        this.money = money;
    }

    private void validationPurchaseMoneyDivisibility(Integer money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_DIVISIBILITY_ERROR_MESSAGE);
        }
    }

    private void validationPurchaseMoneyMinumum(Integer money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(MINIMUM_PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getBuyLottoCount() {
        return money / LOTTO_PRICE;
    }
}

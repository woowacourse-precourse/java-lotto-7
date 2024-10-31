package lotto.domain;

import lotto.constant.NumberConstant;

import static lotto.constant.ErrorMessage.*;

public class PurchaseMoney {

    private final int money;

    public PurchaseMoney(final int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money % NumberConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(CAN_NOT_DIVIDE_MONEY.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}

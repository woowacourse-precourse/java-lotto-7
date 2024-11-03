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
        validatePositiveNumber(money);
        validateDivideLottoPrice(money);
        validateTotalAmount(money);
    }

    private void validateDivideLottoPrice(int money) {
        if (money % NumberConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(CAN_NOT_DIVIDE_MONEY.getMessage());
        }
    }

    private void validatePositiveNumber(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ONLY_POSITIVE_NUMBER.getMessage());
        }
    }

    private void validateTotalAmount(int money) {
        if (money > 100_000) {
            throw new IllegalArgumentException(JUST_FOR_FUN.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}

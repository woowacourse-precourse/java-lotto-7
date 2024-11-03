package lotto.domain;

import lotto.global.message.ErrorMessage;

public class Money {
    private long purchaseAmount;
    private static final int MINIMUM_LOTTO_PRICE = 1000;
    private static final int LOTTO_PRICE_UNIT = 1000;

    public Money(long money) {
        validateMoney(money);
        this.purchaseAmount = money;
    }

    private void validateMoney(long money) {
        validateMinimumAmount(money);
        validateDivisibleByLottoPrice(money);
    }

    private void validateMinimumAmount(long money) {
        if (money < MINIMUM_LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PURCHASE_AMOUNT);
        }
    }

    private void validateDivisibleByLottoPrice(long money) {
        if (isNotDivisibleByUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT);
        }
    }
    private boolean isNotDivisibleByUnit(long money) {
        return money % LOTTO_PRICE_UNIT != 0;
    }

    public long getLottoQuantity() {
        return purchaseAmount / LOTTO_PRICE_UNIT;
    }
}

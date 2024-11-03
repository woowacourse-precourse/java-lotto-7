package lotto.domain;

import lotto.global.message.ErrorMessage;

public class Money {
    private static final int MINIMUM_LOTTO_PRICE = 1000;
    private static final int LOTTO_PRICE_UNIT = 1000;

    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        validateMoney(amount);
        return new Money(amount);
    }

    private static void validateMoney(long money) {
        validateMinimumAmount(money);
        validateDivisibleByLottoPrice(money);
    }

    private static void validateMinimumAmount(long money) {
        if (money < MINIMUM_LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PURCHASE_AMOUNT);
        }
    }

    private static void validateDivisibleByLottoPrice(long money) {
        if (isNotDivisibleByUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT);
        }
    }

    private static boolean isNotDivisibleByUnit(long money) {
        return money % LOTTO_PRICE_UNIT != 0;
    }

    public long getLottoQuantity() {
        return amount / LOTTO_PRICE_UNIT;
    }

    public static int getLottoPriceUnit() {
        return LOTTO_PRICE_UNIT;
    }
}

package lotto.purchase.domain;

import static lotto.common.exception.ExceptionName.MONEY_MIN_UNIT;
import static lotto.common.exception.ExceptionName.MONEY_MIN_VALUE;
import static lotto.common.rule.Rule.LOTTO_PRICE;
import static lotto.common.rule.Rule.MONEY_MINIMUM_VALUE;

import lotto.common.exception.ExceptionName;

public class Money {

    private final long moneyValue;

    private Money(long moneyValue) {
        this.moneyValue = moneyValue;
    }

    public static Money of(long money) {
        validateMoney(money);
        return new Money(money);
    }

    private static void validateMoney(long moneyValue) {
        if (moneyValue <= 0) {
            throw new IllegalArgumentException(ExceptionName.MONEY_NEG_NUM);
        }
        if (moneyValue < MONEY_MINIMUM_VALUE) {
            throw new IllegalArgumentException(MONEY_MIN_VALUE);
        }
        if (moneyValue % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_MIN_UNIT);
        }
    }

    public long getQuantitiesCanBuy() {
        return moneyValue / LOTTO_PRICE;
    }

    public double calculateRateOfIncome(long amount) {
        return ((double) amount / moneyValue) * 100;
    }
}

package lotto.purchase.domain;

import lotto.common.rule.Rule;

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
            throw new IllegalArgumentException("[ERROR] 금액은 음수일 수 없습니다.");
        }
        if (moneyValue < Rule.MONEY_MINIMUM_VALUE) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 미만일 수 없습니다.");
        }
        if (moneyValue % Rule.MONEY_MINIMUM_VALUE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다");
        }
    }

    public long getQuantitiesCanBuy() {
        return moneyValue / Rule.LOTTO_PRICE;
    }

    public double calculateRateOfIncome(long amount) {
        return ((double) amount / moneyValue) * 100;
    }
}

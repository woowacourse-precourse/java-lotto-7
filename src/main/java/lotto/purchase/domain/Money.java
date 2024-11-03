package lotto.purchase.domain;

public class Money {

    private static final int MINIMUM_MONEY_VALUE = 1000;

    private final long moneyValue;

    private Money(long moneyValue) {
        this.moneyValue = moneyValue;
    }

    public static Money of(long money) {
        validateMoney(money);
        return new Money(money);
    }

    public long getQuantitiesCanBuy() {
        return moneyValue / 1000;
    }

    public double calculateRateOfIncome(long amount) {
        return ((double) amount / moneyValue) * 100;
    }

    private static void validateMoney(long moneyValue) {
        if (moneyValue <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수일 수 없습니다.");
        }
        if (moneyValue < MINIMUM_MONEY_VALUE) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 미만일 수 없습니다.");
        }
        if (moneyValue % MINIMUM_MONEY_VALUE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000월 단위로 나눠 떨어져야 합니다");
        }
    }
}

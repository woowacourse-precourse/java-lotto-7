package lotto.model;

public class Money {
    private static final long MINIMUM_AMOUNT = 0L;
    private static final long LOTTO_PRICE_UNIT = 1000L;

    private long money;

    public Money(long money) {
        validateAmount(money);
        this.money = money;
    }

    public Money add(Money other) {
        return new Money(money + other.money);
    }

    public Money multiply(long number) {
        return new Money(money * number);
    }

    public double divide(Money other) {
        return (double) money / other.money;
    }

    private void validateAmount(long amount) {
        if (amount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
        if (amount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public long toLong() {
        return money;
    }
}

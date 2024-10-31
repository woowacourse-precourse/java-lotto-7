package lotto.domain;

public class Money {
    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money from(String amount) {
        try {
            return new Money(Long.parseLong(amount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아니거나, long의 범위를 벗어났습니다.", e);
        }
    }

    public static Money from(long amount) {
        return new Money(amount);
    }

    public Money minus(Money money) {
        return new Money(this.amount - money.amount);
    }

    public boolean isZero() {
        return amount == 0;
    }

    public boolean isGreaterEqualThan(Money money) {
        return this.amount >= money.amount;
    }

    public double calculateRevenue(Money baseAmount) {
        if (baseAmount.isZero()) {
            throw new IllegalArgumentException("기준 금액은 0이 될 수 없습니다.");
        }
        return ((double) this.amount / baseAmount.amount) * 100;
    }
}

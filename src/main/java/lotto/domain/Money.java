package lotto.domain;

public class Money {

    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }

    public static Money from(long amount) {
        return new Money(amount);
    }

    public Money minus(Money money) {
        return new Money(this.amount - money.amount);
    }

    public Money multiply(int multiplier) {
        return new Money(this.amount * multiplier);
    }

    public boolean isZero() {
        return amount == 0;
    }

    public boolean isGreaterEqualThan(Money money) {
        return this.amount >= money.amount;
    }

    public double calculateRevenue(Money investmentMoney) {
        if (investmentMoney.isZero()) {
            throw new IllegalArgumentException("투자 금액은 0이 될 수 없습니다.");
        }
        return ((double) this.amount / investmentMoney.amount) * 100;
    }
}

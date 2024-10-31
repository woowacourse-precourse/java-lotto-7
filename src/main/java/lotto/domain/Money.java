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

    public Money divide(Money money) {
        return new Money(this.amount / money.amount);
    }

    public Money minus(Money money) {
        return new Money(this.amount - money.amount);
    }

    public Money multiply(Money money) {
        return new Money(this.amount * money.amount);
    }

    public boolean isZero() {
        return amount == 0;
    }

    public boolean isGreaterThan(long amount) {
        return this.amount > amount;
    }

    public long getAmount() {
        return amount;
    }

    // 수익률을 계산하는 메서드 (예: 기준 금액 대비 수익률을 백분율로 반환)
    public double calculateRevenue(Money baseAmount) {
        if (baseAmount.isZero()) {
            throw new IllegalArgumentException("기준 금액은 0이 될 수 없습니다.");
        }
        return ((double) this.amount / baseAmount.amount) * 100;
    }
}

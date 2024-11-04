package lotto.domain.money;

import java.util.Objects;

public class Money {
    private static final String ERROR_NEGATIVE = "[ERROR] 금액은 0보다 커야 합니다.";
    private static final String ERROR_NOT_UNIT = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.";
    private static final int UNIT_PRICE = 1_000;

    private final long amount;

    private Money(long amount) {
        validateAmount(amount);
        validateUnit(amount);
        this.amount = amount;
    }

    public static Money from(long amount) {
        return new Money(amount);
    }

    private void validateAmount(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE);
        }
    }

    private void validateUnit(long amount) {
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_NOT_UNIT);
        }
    }

    public int calculateLottoCount() {
        return (int) (amount / UNIT_PRICE);
    }

    public double calculateProfitRate(Money prizeMoney) {
        return Math.round((double) prizeMoney.amount / this.amount * 1000.0) / 10.0;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
package lotto.domain.money;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1_000;
    private static final String ERROR_NEGATIVE = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    private static final String ERROR_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    private final int amount;

    private Money(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    public static Money sum(Money... moneys) {
        int sum = 0;
        for (Money money : moneys) {
            sum += money.amount;
        }
        return new Money(sum);
    }

    public static Money multiply(Money money, int multiplier) {
        return new Money(money.amount * multiplier);
    }

    private void validateAmount(int amount) {
        validatePositive(amount);
        validateUnit(amount);
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE);
        }
    }

    private void validateUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }

    public int getLottoQuantity() {
        return amount / LOTTO_PRICE;
    }

    public double calculateProfitRate(Money prizeMoney) {
        return Math.round((double) prizeMoney.amount / this.amount * 1000.0) / 10.0;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.format("%,d원", amount);
    }
}

package lotto.domain.money;

import lotto.validator.PurchaseAmountValidator;
import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1_000;
    private static final Money ZERO = new Money(0);
    private final int amount;

    private Money(int amount) {
        if (amount != 0) {
            PurchaseAmountValidator.validate(amount);
        }
        this.amount = amount;
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    public static Money zero() {
        return ZERO;
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
}
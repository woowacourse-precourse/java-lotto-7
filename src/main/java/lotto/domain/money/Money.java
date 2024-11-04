package lotto.domain.money;

import lotto.validator.PurchaseAmountValidator;
import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1_000;
    private static final Money ZERO = new Money(0, true);  // ZERO 객체 생성 시 검증 스킵을 위한 true
    private final int amount;

    private Money(int amount) {
        PurchaseAmountValidator.validate(amount);
        this.amount = amount;
    }

    private Money(int amount, boolean skipValidation) {
        this.amount = amount;
    }

    public static Money from(int amount) {
        if (amount == 0) {
            return ZERO;
        }
        return new Money(amount);
    }

    public static Money zero() {
        return ZERO;
    }

    public int getLottoQuantity() {
        return amount / LOTTO_PRICE;
    }

    public double calculateProfitRate(Money prizeMoney) {
        if (this.amount == 0) {
            return 0.0;
        }
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
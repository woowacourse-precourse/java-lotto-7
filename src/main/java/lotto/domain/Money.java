package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {

    private final BigInteger amount;

    public Money(BigInteger amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(BigInteger amount) {
        if (isInvalidNumber(amount)) {
            throw new IllegalArgumentException("금액이 올바르지 않습니다.");
        }
    }

    private boolean isInvalidNumber(BigInteger amount) {
        if (amount == null) {
            return true;
        }
        return amount.compareTo(BigInteger.ZERO) < 0;
    }

    public BigInteger remainder(Money money) throws ArithmeticException {
        return this.amount.remainder(money.amount);
    }

    public BigInteger divide(Money money) throws ArithmeticException {
        return this.amount.divide(money.amount);
    }

    public BigDecimal ratePercentage(Money money) throws ArithmeticException {
        BigDecimal thisDecimal = new BigDecimal(this.amount);
        BigDecimal moneyDecimal = new BigDecimal(money.amount);
        return thisDecimal.divide(moneyDecimal, 3, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"))
                .setScale(1, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return this.amount.equals(money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }

}

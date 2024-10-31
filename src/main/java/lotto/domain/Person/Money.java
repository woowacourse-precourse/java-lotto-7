package lotto.domain.Person;

import java.math.BigInteger;

public class Money {

    private final BigInteger amount;

    public Money(BigInteger amount) {
        this.amount = amount;
        validGreaterThanZero();
    }

    public double calculateReturnRate(Money initialInvestment) {
        double rate = (this.amount.doubleValue() / initialInvestment.amount.doubleValue()) * 100;
        return Math.round(rate * 10) / 10.0;
    }

    private void validGreaterThanZero() {
        if (amount.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("금액은 0 이상이어야 합니다.");
        }
    }

    public BigInteger getAmount() {
        return amount;
    }
}

package lotto.domain;

import java.math.BigInteger;

public class Money {

    private final BigInteger amount;

    public Money(BigInteger amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(BigInteger amount) {
        if (isInvalidNumber(amount)) {
            throw new IllegalArgumentException("로또 구입 금액이 올바르지 않습니다.");
        }
    }

    private boolean isInvalidNumber(BigInteger amount) {
        if (amount == null) {
            return true;
        }
        return amount.compareTo(BigInteger.ZERO) <= 0;
    }

}

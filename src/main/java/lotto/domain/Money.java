package lotto.domain;

import java.math.BigInteger;

public class Money {

    private static final BigInteger LOTTO_PRICE = BigInteger.valueOf(1000);

    private final BigInteger amount;

    public Money(BigInteger amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(BigInteger amount) {
        if (isInvalidNumber(amount)) {
            throw new IllegalArgumentException("로또 구입 금액이 올바르지 않습니다.");
        }

        if (!dividedByLottoPrice(amount)) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    private boolean isInvalidNumber(BigInteger amount) {
        if (amount == null) {
            return true;
        }
        return amount.compareTo(BigInteger.ZERO) <= 0;
    }

    private boolean dividedByLottoPrice(BigInteger amount) {
        BigInteger remainder = amount.remainder(LOTTO_PRICE);
        return remainder.compareTo(BigInteger.ZERO) == 0;
    }

}

package lotto.domain;

import lotto.exception.LottoException;

public record Money(int amount) {

    private static final int MIN_AMOUNT = 0;

    public Money {
        validate(amount);
    }

    public static Money from(final int amount) {
        return new Money(amount);
    }

    public boolean isMultipleOf(final Money unit) {
        return this.amount % unit.amount == 0;
    }

    public int divide(final Money unit) {
        return this.amount / unit.amount;
    }

    private void validate(final int amount) {
        if (amount < MIN_AMOUNT) {
            throw new LottoException("금액은 음수일 수 없습니다.");
        }
    }
}

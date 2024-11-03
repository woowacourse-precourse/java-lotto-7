package lotto.domain;

import lotto.exception.LottoException;

public record Money(int amount) {

    private static final int MIN_AMOUNT = 0;
    private static final int UNIT_AMOUNT = 1000;

    public Money {
        validate(amount);
    }

    private void validate(final int amount) {
        if (amount < MIN_AMOUNT || amount % UNIT_AMOUNT != 0) {
            throw new LottoException("금액은 1000원으로 나누어 떨어지는 자연수여야 합니다.");
        }
    }
}

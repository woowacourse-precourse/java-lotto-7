package lotto.domain;

import lotto.exception.LottoException;

public record Money(int amount) {

    public Money {
        validate(amount);
    }

    private void validate(final int amount) {
        if (amount < 0 || amount % 1000 != 0) {
            throw new LottoException("금액은 1000원으로 나누어 떨어지는 자연수여야 합니다.");
        }
    }
}

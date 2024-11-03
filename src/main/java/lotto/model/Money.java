package lotto.model;

import java.math.BigDecimal;
import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

public record Money(int amount) {
    public Money {
        validate(amount);
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    private static void validate(int amount) {
        if (amount < 0 || amount % 1000 != 0) {
            throw new LottoException(ErrorMessages.AMOUNT_INVALID);
        }
    }

    public int divide(int value) {
        if (value == 0) {
            throw new ArithmeticException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return amount / value;
    }

    public boolean isZero() {
        return amount == 0;
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(amount);
    }

    public Money plus(Money other) {
        if (other == null) {
            throw new LottoException(ErrorMessages.OTHER_NULL);
        }
        return new Money(this.amount + other.amount());
    }
}

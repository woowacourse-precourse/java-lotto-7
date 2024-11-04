package lotto.domain;

import static lotto.common.ExceptionMessage.FOLLOW_MONEY_UNIT;
import static lotto.common.ExceptionMessage.MONEY_MUST_POSITIVE;
import static lotto.common.LottoConstant.*;

import java.math.BigDecimal;

public record Money(
        BigDecimal amount
) {

    public Money(BigDecimal amount) {
        validatePositive(amount);
        validateUnit(amount);
        this.amount = amount;
    }

    public static Money from(int money) {
        return new Money(BigDecimal.valueOf(money));
    }

    private void validatePositive(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(MONEY_MUST_POSITIVE);
        }
    }

    private void validateUnit(BigDecimal amount) {
        if (amount.intValue() % UNIT_OF_MONEY != 0) {
            throw new IllegalArgumentException(FOLLOW_MONEY_UNIT);
        }
    }
}

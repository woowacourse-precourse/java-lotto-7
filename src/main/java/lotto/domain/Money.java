package lotto.domain;

import static lotto.common.LottoConstant.*;

import java.math.BigDecimal;
import lotto.common.LottoConstant;

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
            throw new IllegalArgumentException("입력 금액은 양의 정수여야 합니다.");
        }
    }

    private void validateUnit(BigDecimal amount) {
        if (amount.intValue() % UNIT_OF_MONEY != 0) {
            throw new IllegalArgumentException("입력 금액은 로또 가격에 나누어 떨어져야합니다.");
        }
    }




}

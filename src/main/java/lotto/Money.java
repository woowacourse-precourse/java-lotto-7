package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private final BigDecimal amount;

    public Money(int value) {
        this(BigDecimal.valueOf(value));
    }

    public Money(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(1000)) == -1) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (!BigDecimal.ZERO.equals(amount.remainder(BigDecimal.valueOf(1000)))) { // amount % 1000
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위이어야 합니다.");
        }
        this.amount = amount;
    }

    public int calculateLottoQuantity() {
        BigDecimal value = amount.divide(BigDecimal.valueOf(1000), RoundingMode.UNNECESSARY);
        return value.intValue();
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

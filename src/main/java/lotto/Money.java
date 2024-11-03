package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final BigDecimal amount;

    public Money(int value) {
        this(BigDecimal.valueOf(value));
    }

    public Money(BigDecimal amount) {
        if (isLessThanSingleLottoPrice(amount)) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입 금액은 %d원 이상이어야 합니다.", LOTTO_PRICE));
        }
        if (isNotLottoPriceUnit(amount)) { // amount % 1000
            throw new IllegalArgumentException(String.format("[ERROR] 구입 금액은 %d원 단위이어야 합니다.", LOTTO_PRICE));
        }
        this.amount = amount;
    }

    private boolean isNotLottoPriceUnit(BigDecimal amount) {
        return !BigDecimal.ZERO.equals(amount.remainder(BigDecimal.valueOf(LOTTO_PRICE)));
    }

    private boolean isLessThanSingleLottoPrice(BigDecimal amount) {
        return amount.compareTo(BigDecimal.valueOf(LOTTO_PRICE)) == -1;
    }

    public int calculateLottoQuantity() {
        BigDecimal value = amount.divide(BigDecimal.valueOf(LOTTO_PRICE), RoundingMode.UNNECESSARY);
        return value.intValue();
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

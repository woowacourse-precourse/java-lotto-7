package lotto.constant.lotto;

import java.math.BigDecimal;

public enum LottoConstants {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBERS_COUNT(6),
    LOTTO_UNIT_PRICE(1000);

    private final BigDecimal value;

    LottoConstants(int value) {
        this.value = BigDecimal.valueOf(value);
    }

    public int getIntValue() {
        return value.intValue();
    }

    public BigDecimal getBigDecimalValue() {
        return value;
    }
}

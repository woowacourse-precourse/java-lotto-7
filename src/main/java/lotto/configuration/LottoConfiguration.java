package lotto.configuration;

import lotto.exception.ExceptionUtils;
import lotto.exception.LottoConfigurationExceptionMessage;

public enum LottoConfiguration {
    LOTTO_MAX_NUMBER(45), LOTTO_MIN_NUMBER(1), LOTTO_NUMBER_COUNT(6),

    LOTTO_PRICE(1000), PURCHASE_LIMIT(100_000),
    ;

    static {
        if (LOTTO_MAX_NUMBER.getValue() < LOTTO_MIN_NUMBER.getValue()) {
            throw ExceptionUtils.IllegalArgument(LottoConfigurationExceptionMessage.MAX_NUMBER_LESS_THAN_MIN);
        }
        if (LOTTO_NUMBER_COUNT.getValue() < 1) {
            throw ExceptionUtils.IllegalArgument(LottoConfigurationExceptionMessage.NUMBER_COUNT_LESS_THAN_ONE);
        }
        if (LOTTO_PRICE.getValue() <= 0) {
            throw ExceptionUtils.IllegalArgument(LottoConfigurationExceptionMessage.PRICE_NOT_POSITIVE);
        }
    }

    private final int value;

    LottoConfiguration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package lotto.domain;

import static lotto.service.exception.LottoExceptionMessage.PRICE_NOT_THOUSANDS_UNIT;

import lotto.service.exception.LottoException;

public class Price {

    private static final int PRICE_UNIT = 1_000;

    private final int value;

    private Price(int value) {
        validate(value);
        this.value = value;
    }

    public static Price from(int value) {
        return new Price(value);
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return value / PRICE_UNIT;
    }

    private void validate(int value) {
        if (value % PRICE_UNIT != 0) {
            throw new LottoException(PRICE_NOT_THOUSANDS_UNIT);
        }
    }
}

package lotto.model.vo;

import java.text.NumberFormat;
import java.util.Locale;
import lotto.exception.ErrorStatus;
import lotto.exception.handler.MoneyErrorHandler;

public record Money(int value) {
    private static final int MIN_AMOUNT_UNIT = 1000;
    private static final String MONEY_UNIT = "원";

    public Money {
        validateUnit(value);
        validatePositiveNumber(value);
    }

    private void validateUnit(int value) {
        if (value % MIN_AMOUNT_UNIT != 0) {
            throw new MoneyErrorHandler(ErrorStatus.MONEY_MIN_UNIT_ERROR);
        }
    }

    private void validatePositiveNumber(int value) {
        if (value < 0) {
            throw new MoneyErrorHandler(ErrorStatus.MONEY_NON_POSITIVE_ERROR);
        }
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        return numberFormat.format(value) + MONEY_UNIT;
    }
}

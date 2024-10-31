package lotto;

import java.math.BigDecimal;

public class Money {

    private final int value;

    public Money(final int value) {
        validate(value);
        this.value = value;
    }

    public int calculateQuotient(final int number) {
        return value / number;
    }

    public double calculateRatio(final BigDecimal value) {
        return (this.value / value.doubleValue()) * 100;
    }


    private void validate(final int value) {
        final LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        lottoNumberValidator.validateUnit(value, 1_000);
    }

}

package lotto.domain.purchase;

import java.math.BigDecimal;
import lotto.constant.LottoRule;
import lotto.util.NumberValidator;

public class Money {

    private static final int PERCENTAGE_MULTIPLIER = 100;
    private final int value;

    public Money(final int value) {
        validate(value);
        this.value = value;
    }

    public int calculateQuotient(final int number) {
        return value / number;
    }

    public double calculateRatio(final BigDecimal value) {
        return (value.longValue() / (double) this.value) * PERCENTAGE_MULTIPLIER;
    }

    private void validate(final int value) {
        final NumberValidator<Integer> numberValidator = NumberValidator.getInstance();
        numberValidator.validateUnit(value, LottoRule.MONEY_UNIT);
    }

}

package lotto.util.validator;

import lotto.exception.MoneyError;
import lotto.exception.MoneyException;

public final class MoneyValidator {

    private static final int MONEY_AMOUNT_UNIT = 1_000;

    private MoneyValidator() {
    }

    public static void validate(final long amount) {
        validateUnit(amount);
    }

    private static void validateUnit(final long amount) {
        if (amount % MONEY_AMOUNT_UNIT != 0) {
            throw new MoneyException(MoneyError.NOT_DIVISIBLE_TO_THOUSAND);
        }
    }

}

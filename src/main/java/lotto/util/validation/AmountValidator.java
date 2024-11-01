package lotto.util.validation;

import static lotto.exception.ExceptionMessage.INVALID_AMOUNT_UNIT;
import static lotto.exception.ExceptionMessage.INVALID_AMOUNT_ZERO;

public class AmountValidator extends NumberValidator {

    public static final int AMOUNT_UNIT = 1000;
    private static final double ZERO_AMOUNT = 0.0;


    @Override
    public void validate(String target) {
        super.validate(target);
        validateZero(target);
        validateAmountUnit(target);
    }

    private void validateZero(String target) {
        int amount = Integer.parseInt(target);
        if (amount == ZERO_AMOUNT) {
            throwFail(INVALID_AMOUNT_ZERO.format());
        }
    }

    private void validateAmountUnit(String target) {
        int amount = Integer.parseInt(target);
        if (amount % AMOUNT_UNIT != ZERO_AMOUNT) {
            throwFail(INVALID_AMOUNT_UNIT.format(target, AMOUNT_UNIT));
        }
    }
}
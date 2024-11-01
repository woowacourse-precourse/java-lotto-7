package lotto.util.validation;

import static lotto.exception.ExceptionMessage.INVALID_AMOUNT_UNIT;
import static lotto.exception.ExceptionMessage.INVALID_AMOUNT_ZERO;

public class AmountValidator extends NumberValidator {

    public static final int AMOUNT_UNIT = 1000;

    @Override
    public void validate(String target) {
        super.validate(target);
        validateZero(target);
        validateAmountUnit(target);
    }

    private void validateZero(String target) {
        int amount = Integer.parseInt(target);
        if (amount == 0) {
            throwFail(INVALID_AMOUNT_ZERO.format());
        }
    }

    private void validateAmountUnit(String target) {
        int amount = Integer.parseInt(target);
        if (amount % AMOUNT_UNIT != 0) {
            throwFail(INVALID_AMOUNT_UNIT.format(target, AMOUNT_UNIT));
        }
    }
}
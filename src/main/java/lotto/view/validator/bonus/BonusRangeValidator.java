package lotto.view.validator.bonus;

import static lotto.error.ErrorMessage.NUMBER_OUT_OF_RANGE;

import lotto.view.validator.RangeValidator;

public class BonusRangeValidator extends RangeValidator {

    private BonusRangeValidator() {
        super(String.format(NUMBER_OUT_OF_RANGE.getMessage(), MIN_RANGE, MAX_RANGE));
    }

    public static BonusRangeValidator initiate() {
        return new BonusRangeValidator();
    }
}

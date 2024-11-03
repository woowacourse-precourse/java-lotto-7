package lotto.view.validator.winningNumber;

import static lotto.error.ErrorMessage.NUMBER_OUT_OF_RANGE;

import lotto.view.validator.RangeValidator;

public class WinningNumRangeValidator extends RangeValidator {


    private WinningNumRangeValidator() {
        super(String.format(NUMBER_OUT_OF_RANGE.getMessage(), MIN_RANGE, MAX_RANGE));
    }

    public static WinningNumRangeValidator initiate() {
        return new WinningNumRangeValidator();
    }
}

package lotto.validator.strategy;

import lotto.exception.custom.InvalidBonusNumberFormat;
import lotto.validator.InputValidator;

public class BonusNumberValidator implements InputValidator {

    private static final String BONUS_NUMBER_PATTERN = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";

    @Override
    public void validate(String input) {
        if (isBonusNumberFormatInvalid(input)) {
            throw new InvalidBonusNumberFormat();
        }
    }

    private boolean isBonusNumberFormatInvalid(String inputBonusNumber) {
        return !inputBonusNumber.matches(BONUS_NUMBER_PATTERN);
    }
}

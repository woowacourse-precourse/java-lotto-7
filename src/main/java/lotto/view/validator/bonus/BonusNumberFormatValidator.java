package lotto.view.validator.bonus;

import static lotto.error.ErrorMessage.POSITIVE_REQUIRED;

import lotto.view.validator.NumberFormatValidator;

public class BonusNumberFormatValidator extends NumberFormatValidator {

    private BonusNumberFormatValidator() {
        super(POSITIVE_REQUIRED.getMessage());
    }

    public static BonusNumberFormatValidator initiate() {
        return new BonusNumberFormatValidator();
    }
}

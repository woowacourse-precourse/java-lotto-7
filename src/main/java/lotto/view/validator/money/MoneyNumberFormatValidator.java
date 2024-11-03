package lotto.view.validator.money;

import static lotto.error.ErrorMessage.POSITIVE_REQUIRED;

import lotto.view.validator.NumberFormatValidator;

public class MoneyNumberFormatValidator extends NumberFormatValidator {

    private MoneyNumberFormatValidator() {
        super(POSITIVE_REQUIRED.getMessage());
    }

    public static MoneyNumberFormatValidator initiate() {
        return new MoneyNumberFormatValidator();
    }
}

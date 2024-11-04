package lotto.view.validator.bonus;

import static lotto.error.ErrorMessage.INVALID_EMPTY_INPUT;

import lotto.view.validator.NullValidator;

public class BonusNullValidator extends NullValidator {

    private BonusNullValidator() {
        super(INVALID_EMPTY_INPUT.getMessage());
    }

    public static BonusNullValidator initiate() {
        return new BonusNullValidator();
    }
}

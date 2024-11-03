package lotto.view.validator.money;

import static lotto.error.ErrorMessage.INVALID_EMPTY_INPUT;

import lotto.view.validator.NullValidator;

public class MoneyNullValidator extends NullValidator {

    private MoneyNullValidator() {
        super(INVALID_EMPTY_INPUT.getMessage());
    }

    public static MoneyNullValidator initiate() {
        return new MoneyNullValidator();
    }
}

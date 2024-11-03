package lotto.view.validator.winningNumber;

import static lotto.error.ErrorMessage.INVALID_EMPTY_INPUT;

import lotto.view.validator.NullValidator;

public class WinningNumNullValidator extends NullValidator {

    private WinningNumNullValidator() {
        super(INVALID_EMPTY_INPUT.getMessage());
    }

    public static WinningNumNullValidator initiate() {
        return new WinningNumNullValidator();
    }
}

package lotto.validator.factory;

import lotto.validator.*;
import lotto.validator.strategy.BonusNumberValidator;
import lotto.validator.strategy.PurchaseAmountValidator;
import lotto.validator.strategy.WinningNumberValidator;
import lotto.validator.type.InputType;

import static lotto.validator.type.InputType.*;

public class InputValidatorStrategyFactory {

    public InputValidator getValidator(InputType inputType) {
        if (inputType.equals(PURCHASE_AMOUNT)) {
            return new PurchaseAmountValidator();
        }
        if (inputType.equals(WINNING_NUMBER)) {
            return new WinningNumberValidator();
        }
        return new BonusNumberValidator();
    }
}

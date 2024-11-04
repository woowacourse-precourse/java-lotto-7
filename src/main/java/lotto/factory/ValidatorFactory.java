package lotto.factory;

import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumberValidator;

public class ValidatorFactory {

    public PurchaseAmountValidator createPurchaseAmountValidator() {
        return new PurchaseAmountValidator();
    }

    public WinningNumberValidator createWinningNumberValidator() {
        return new WinningNumberValidator();
    }

    public BonusNumberValidator createBonusNumberValidator() {
        return new BonusNumberValidator();
    }
}

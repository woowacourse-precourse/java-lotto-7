package lotto.handler;


import lotto.validator.BonusNumberValidator;

public class BonusNumberHandler {
    public static boolean handle(String purchaseAmount) {
        return BonusNumberValidator.validateBlank(purchaseAmount) && BonusNumberValidator.validateDataType(purchaseAmount) && BonusNumberValidator.validateRange(purchaseAmount);
    }
}

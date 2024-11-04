package lotto.exception;

import lotto.view.InputView;

public class ValidateValues {

    public static int purchaseAmount(String inputPurchaseAmount) {
        boolean notBlankResult = InputValidation.NOT_BLANK.validate(inputPurchaseAmount);
        boolean notDivisibleBy1000 = InputValidation.NOT_DIVISIBLE_BY_1000.validate(inputPurchaseAmount);
        if(notBlankResult && notDivisibleBy1000) {
            return Integer.parseInt(inputPurchaseAmount);
        }
        String inputPurchaseAmountAgain = InputView.getLottoPurchaseAmount();
        purchaseAmount(inputPurchaseAmountAgain);
        return Integer.parseInt(inputPurchaseAmountAgain);
    }

    public static boolean winningNumberOrBonusNumber(String winningNumber) {
        if(InputValidation.NOT_NUMBER.validate(winningNumber)
            && InputValidation.NOT_INTEGER.validate(winningNumber)
            && InputValidation.NOT_IN_RANGE_1_TO_45.validate(winningNumber)) {
            return true;
        }
        return false;
    }

}

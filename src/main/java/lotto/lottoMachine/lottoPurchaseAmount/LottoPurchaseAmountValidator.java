package lotto.lottoMachine.lottoPurchaseAmount;

import lotto.utils.StaticFinalMessages;

public class LottoPurchaseAmountValidator {
    public boolean validateAllThing(String lottoPurchaseAmount) {
        return validateIsNumeric(lottoPurchaseAmount)
                && validateExceed50000(lottoPurchaseAmount)
                && validateUnit1000(lottoPurchaseAmount);
    }

    // number format exception 말고 또 다른 것도 있나?
    private boolean validateIsNumeric(String lottoPurchaseAmount) {
        try {
            Integer.parseInt(lottoPurchaseAmount);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private boolean validateExceed50000(String lottoPurchaseAmount) {
        int convertedInputToInt = Integer.parseInt(lottoPurchaseAmount);
        return convertedInputToInt <= StaticFinalMessages.MAXIMUM_NUM_OF_LOTTO_PURCHASE_AMOUNT && convertedInputToInt >= StaticFinalMessages.MINIMUM_NUM_OF_LOTTO_PURCHASE_AMOUNT;
    }

    private boolean validateUnit1000(String lottoPurchaseAmount) {
        int convertedInputToInt = Integer.parseInt(lottoPurchaseAmount);
        return convertedInputToInt % 1000 == 0;
    }
}

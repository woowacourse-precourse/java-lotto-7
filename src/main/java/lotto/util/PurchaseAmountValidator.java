package lotto.util;

import static lotto.constants.PurchaseAmountErrorMessage.*;

public class PurchaseAmountValidator implements Validator {

    private static final int MINIMUM_AMOUNT = 1000;

    @Override
    public void validate(String input) {
        int purchaseAmount = isNumber(input);
        hasMinimum(purchaseAmount);
        isDivisibleByMinimumAmount(purchaseAmount);
    }

    private void isDivisibleByMinimumAmount(int purchaseAmount) {
        if (!(purchaseAmount % MINIMUM_AMOUNT == 0)) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_MINIMUM.getMessage());
        }
    }

    private void hasMinimum(int purchaseAmount) {
        if (purchaseAmount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(BELOW_MINIMUM_AMOUNT.getMessage());
        }
    }

    private int isNumber(String input) {
        try {
            return StringParser.toInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}

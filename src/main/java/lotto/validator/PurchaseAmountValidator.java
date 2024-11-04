package lotto.validator;

import lotto.view.OutputView;

import static lotto.model.constants.PurchaseAmountValidatorConstants.*;

public class PurchaseAmountValidator {

    public static boolean checkValidPurchaseAmount(String inputAmount) throws IllegalArgumentException {
        try {
            isNumeric(inputAmount);
            isAmountInRange(inputAmount);
            amountIsPositive(inputAmount);
            isMultipleOfThousand(inputAmount);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return false;
        }
        return true;
    }

    private static void isNumeric(String inputAmount) throws IllegalArgumentException {
        if (!inputAmount.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NUMERIC_MESSAGE.getMessage());
        }
    }

    private static void isAmountInRange(String inputAmount) throws IllegalArgumentException {
        if (inputAmount.length() > 7) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_IN_RANGE_MESSAGE.getMessage());
        }
    }

    private static void amountIsPositive(String inputAmount) throws IllegalArgumentException {
        long amount = Long.parseLong(inputAmount);
        if (amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_POSITIVE_MESSAGE.getMessage());
        }
    }

    private static void isMultipleOfThousand(String inputAmount) throws IllegalArgumentException {
        long amount = Long.parseLong(inputAmount);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND_MESSAGE.getMessage());
        }
    }
}

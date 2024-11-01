package lotto.validators;

import lotto.validators.constants.ErrorMessages;

public class PurchaseAmountValidator implements NumberInputValidator {
    private static final int MIN_VALUE = 1000;
    private static final int MAX_VALUE = 100000;

    @Override
    public boolean isValid(String input) {
        boolean isValid = true;
        try {
            checkInputType(input);
            checkDivisibility(input);
            checkValueRange(input);
        } catch (IllegalArgumentException e) {
            isValid = false;
            System.out.println(ErrorMessages.ERROR_HEADER.getMessage() + e.getMessage());
        }
        return isValid;
    }

    public void checkDivisibility(String input) {
        int amount = Integer.parseInt(input);
        if (amount % MIN_VALUE != 0) {
            throw new IllegalArgumentException(ErrorMessages.NOT_DIVISIBLE.getMessage());
        }
    }

    public void checkValueRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < MIN_VALUE || amount > MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.PURCHASE_AMOUNT_NOT_WITHIN_RANGE.getMessage());
        }
    }
}

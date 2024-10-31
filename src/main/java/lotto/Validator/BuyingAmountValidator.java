package lotto.Validator;

import lotto.exception.BuyingAmountException;
import lotto.exception.BuyingAmountFormatException;
import lotto.exception.BuyingAmountOutOfBoundsException;
import lotto.exception.CannotDividedInThousandException;

public class BuyingAmountValidator {
    public int validateBuyingAmount(String input) throws BuyingAmountException {
        validateLength(input);
        validateFormat(input);
        int amount = validateRange(input);
        validateDivisionIntoThousand(amount);
        return amount;
    }

    private void validateLength(String input) {
        if (input.length() > 6) {
            throw new BuyingAmountOutOfBoundsException();
        }
    }

    private void validateFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new BuyingAmountFormatException();
        }
    }

    private int validateRange(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount > 100000) {
            throw new BuyingAmountOutOfBoundsException();
        }
        return amount;
    }

    private void validateDivisionIntoThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new CannotDividedInThousandException();
        }
    }
}

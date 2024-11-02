package lotto.validator;

import lotto.exception.BuyingAmountException;
import lotto.exception.BuyingAmountFormatException;
import lotto.exception.BuyingAmountOutOfBoundsException;
import lotto.exception.CannotDividedInThousandException;

public class BuyingAmountValidator {
    private final int LOTTO_NUMBER_QUANTITY = 6;
    private final int PRICE_OF_SINGLE_LOTTO = 1000;
    private final int MAX_BUYING_AMOUNT = 100000;

    public int validateBuyingAmount(String input) throws BuyingAmountException {
        validateLength(input);
        validateFormat(input);
        int amount = validateRange(input);
        validateDivisionIntoThousand(amount);
        return amount;
    }

    private void validateLength(String input) {
        if (input.length() > LOTTO_NUMBER_QUANTITY) {
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
        if (amount < PRICE_OF_SINGLE_LOTTO || amount > MAX_BUYING_AMOUNT) {
            throw new BuyingAmountOutOfBoundsException();
        }
        return amount;
    }

    private void validateDivisionIntoThousand(int amount) {
        if (amount % PRICE_OF_SINGLE_LOTTO != 0) {
            throw new CannotDividedInThousandException();
        }
    }
}

package lotto.validator;

import lotto.exception.BuyingAmountException;
import lotto.exception.BuyingAmountFormatException;
import lotto.exception.CannotDividedInThousandException;

public class BuyingAmountValidator {
    private final int PRICE_OF_SINGLE_LOTTO = 1000;
    private final int MAX_BUYING_AMOUNT = 100000;
    private final int ZERO = 0;

    public int validateBuyingAmount(String input) throws BuyingAmountException {
        int amount = validateFormat(input);
        validateDivisionIntoThousand(amount);
        return amount;
    }

    private int validateFormat(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount < PRICE_OF_SINGLE_LOTTO || amount > MAX_BUYING_AMOUNT) {
                throw new NumberFormatException();
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new BuyingAmountFormatException();
        }
    }

    private void validateDivisionIntoThousand(int amount) {
        if (amount % PRICE_OF_SINGLE_LOTTO != ZERO) {
            throw new CannotDividedInThousandException();
        }
    }
}

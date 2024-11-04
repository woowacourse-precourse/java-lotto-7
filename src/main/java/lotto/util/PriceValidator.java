package lotto.util;

import lotto.enums.ErrorMessage;
import lotto.enums.PriceConstants;

public final class PriceValidator extends Validator {
    public static void validate(String input) {
        checkNumberForm(input);
        checkAmountInRange(input);
        checkThousandUnit(input);
    }

    private static void checkAmountInRange(String input) {
        try {
            int money = Integer.parseInt(input);
            if (money > PriceConstants.MAX_PURCHASE_AMOUNT) {
                throw new IllegalArgumentException(ErrorMessage.OVER_MAX_PURCHASE_AMOUNT.format());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.OVER_MAX_PURCHASE_AMOUNT.format());
        }
    }

    private static void checkThousandUnit(String input) {
        int money = Integer.parseInt(input);
        if (money < PriceConstants.LOTTO_PRICE || money % PriceConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_THOUSAND.format());
        }
    }
}

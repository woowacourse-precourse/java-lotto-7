package lotto.validation;

import static lotto.constants.ErrorMessage.IS_NOT_DIVISIBLE_BY_THOUSAND_WON;
import static lotto.constants.ErrorMessage.PURCAHSE_PRICE_MUST_BE_NATURAL_NUMBER;
import static lotto.constants.LottoConstant.NATURAL_STANDARD;

public class PurchasePriceValidator {

    public static void validator(String price) {
        checkNaturalNumber(price);
        checkDivideIntoThousand(price);
    }

    private static void checkNaturalNumber(String price) {
        try {
            int amount = convertToInteger(price);
            if (amount < NATURAL_STANDARD) {
                throw new IllegalArgumentException(PURCAHSE_PRICE_MUST_BE_NATURAL_NUMBER.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCAHSE_PRICE_MUST_BE_NATURAL_NUMBER.getMessage());
        }
    }

    private static void checkDivideIntoThousand(String price) {
        int amount = convertToInteger(price);
        if (canDivide(amount)) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE_BY_THOUSAND_WON.getMessage());
        }
    }

    private static boolean canDivide(int amount){
        return amount % 1000 != 0;
    }

    private static int convertToInteger(String price) {
        return Integer.parseInt(price);
    }
}

package validator;

import common.ErrorMessage;

public class InputValidator {

    public static void isDivisibleByThousand(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVISIBILITY_BY_THOUSAND_ERROR.getMessage());
        }
    }
}

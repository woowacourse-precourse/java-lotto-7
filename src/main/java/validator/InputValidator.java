package validator;

import common.ErrorMessage;
import common.LottoConstants;

public class InputValidator {

    public static void isDivisibleByThousand(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount % LottoConstants.TICKET_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVISIBILITY_BY_THOUSAND_ERROR.getMessage());
        }
    }
}

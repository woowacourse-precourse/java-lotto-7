package lotto.validator;

import static lotto.message.ExceptionMessage.INVALID_BLANK_INPUT;

import lotto.exception.IllegalInputException;
import org.junit.platform.commons.util.StringUtils;

public class PurchaseAmountValidator {

    public static int validatePurchaseAmount(String purchaseAmount) {

        return Integer.parseInt(purchaseAmount);
    }

    private static void validateBlank(String purchaseAmount) {
        if (StringUtils.isBlank(purchaseAmount)) {
            throw new IllegalInputException(INVALID_BLANK_INPUT.getMessage());
        }
    }


}

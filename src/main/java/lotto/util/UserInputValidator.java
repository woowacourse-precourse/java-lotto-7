package lotto.util;

import static lotto.constant.ErrorMessage.LESS_THAN_THOUSAND_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.TOO_BIG_PURCHASE_AMOUNT;

public class UserInputValidator {
    public void isValidPurchaseAmount(String purchaseAmount) {
        isUserInputNumber(purchaseAmount);
        isPurchaseAmountTooBing(purchaseAmount);
        isPurchaseAmountLessThanThousand(purchaseAmount);
    }

    public void isUserInputNumber(String purchaseAmount) {
        if (!purchaseAmount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void isPurchaseAmountTooBing(String purchaseAmount) {
        if (purchaseAmount.length() > 10) {
            throw new IllegalArgumentException(TOO_BIG_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void isPurchaseAmountLessThanThousand(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) < 1000) {
            throw new IllegalArgumentException(LESS_THAN_THOUSAND_PURCHASE_AMOUNT.getMessage());
        }
    }
}

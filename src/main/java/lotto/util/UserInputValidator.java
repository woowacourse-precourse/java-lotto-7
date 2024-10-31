package lotto.util;

import static lotto.constant.ErrorMessage.LESS_THAN_THOUSAND_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_NUMBER_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.NOT_PURCHASE_AMOUNT_FORMAT;
import static lotto.constant.ErrorMessage.TOO_BIG_PURCHASE_AMOUNT;

public class UserInputValidator {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int PURCHASE_AMOUNT_LENGTH_LIMIT = 10;
    private static final int PURCHASE_AMOUNT_REMAIN = 0;

    public void isValidPurchaseAmount(String purchaseAmount) {
        isUserInputNumber(purchaseAmount);
        isPurchaseAmountTooBing(purchaseAmount);
        isPurchaseAmountLessThanThousand(purchaseAmount);
        isPurchaseAmountMultipleOfThousand(purchaseAmount);
    }

    public void isUserInputNumber(String purchaseAmount) {
        if (!purchaseAmount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void isPurchaseAmountTooBing(String purchaseAmount) {
        if (purchaseAmount.length() > PURCHASE_AMOUNT_LENGTH_LIMIT) {
            throw new IllegalArgumentException(TOO_BIG_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void isPurchaseAmountLessThanThousand(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) < PURCHASE_AMOUNT_UNIT) {
            throw new IllegalArgumentException(LESS_THAN_THOUSAND_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void isPurchaseAmountMultipleOfThousand(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % PURCHASE_AMOUNT_UNIT != PURCHASE_AMOUNT_REMAIN) {
            throw new IllegalArgumentException(NOT_PURCHASE_AMOUNT_FORMAT.getMessage());
        }
    }
}

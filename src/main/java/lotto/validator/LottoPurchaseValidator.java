package lotto.validator;

import static lotto.constant.Constants.LOTTO_PURCHASE_PRICE;
import static lotto.constant.Constants.MINIMUM_LOTTO_AMOUNT;
import static lotto.constant.Constants.NO_REMAINDER;

import lotto.exception.PurchaseException;

public class LottoPurchaseValidator {
    public static int validateAndParse(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(PurchaseException.EMPTY_INPUT.getMessage());
        }

        try {
            long longAmount = Long.parseLong(input);
            if (longAmount > Integer.MAX_VALUE || longAmount < Integer.MIN_VALUE) {
                throw new IllegalArgumentException(PurchaseException.OUT_OF_INT_RANGE.getMessage());
            }
            int amount = (int) longAmount;
            validateAmount(amount);  // 유효성 검증
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PurchaseException.INVALID_FORMAT.getMessage());
        }
    }

    public static void validateAmount(int amount) {
        if (amount <= MINIMUM_LOTTO_AMOUNT) {
            throw new IllegalArgumentException(PurchaseException.NON_POSITIVE_AMOUNT.getMessage());
        }
        if (amount % LOTTO_PURCHASE_PRICE != NO_REMAINDER) {
            throw new IllegalArgumentException(PurchaseException.INVALID_UNIT.getMessage());
        }
    }
}

package lotto.validator;

import static lotto.constant.Constants.LOTTO_PURCHASE_PRICE;
import static lotto.constant.Constants.MINIMUM_LOTTO_AMOUNT;
import static lotto.constant.Constants.NO_REMAINDER;

import lotto.exception.PurchaseException;

public class LottoPurchaseValidator {
    public static void validate(int amount) {
        if (amount <= MINIMUM_LOTTO_AMOUNT) {
            throw new IllegalArgumentException(PurchaseException.NON_POSITIVE_AMOUNT.getMessage());
        }
        if (amount % LOTTO_PURCHASE_PRICE != NO_REMAINDER) {
            throw new IllegalArgumentException(PurchaseException.INVALID_UNIT.getMessage());
        }
    }
}

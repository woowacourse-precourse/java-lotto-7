package lotto.validator;

import lotto.enums.ErrorMessage;

import static lotto.model.PurchaseAmount.LOTTO_PRICE;

public class PurchaseAmountValidator {
    private static final int LOTTO_MAX_PRICE = 100000; //실제 복권과 동일하도록 1회 구입 10만원 제한

    public static void validateAmount(int amount) {
        validateMinPrice(amount);
        validateMaxPrice(amount);
        validateDivisibility(amount);
    }

    private static void validateMinPrice(int amount) {
        if (amount < LOTTO_PRICE)
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MIN_PRICE.getMessage());
    }

    private static void validateMaxPrice(int amount) {
        if (amount > LOTTO_MAX_PRICE)
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MAX_PRICE.getMessage());
    }

    private static void validateDivisibility(int amount) {
        if (amount % LOTTO_PRICE != 0)
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_INVALID_DIVISIBILITY.getMessage());
    }
}

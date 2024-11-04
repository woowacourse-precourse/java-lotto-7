package lotto.validator;

import static lotto.model.enums.ErrorMessage.*;

public class InputValidator {
    static final int LOTTO_PRICE = 1000;

    public static void validateOrderPricePositive(int orderCount) {
        if (orderCount <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PRICE.getMessage());
        }
    }

    public static void validateOrderPriceUnit(int orderPrice) {
        if (orderPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PRICE.getMessage());
        }
    }
}

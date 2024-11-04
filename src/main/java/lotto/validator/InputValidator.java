package lotto.validator;

import static lotto.model.enums.ErrorMessage.*;

public class InputValidator {
    static final int LOTTO_PRICE = 1000;

    public static void validateOrderPrice(String orderPriceInput) {
        try {
            int orderPrice = Integer.parseInt(orderPriceInput);
            validateOrderPricePositive(orderPrice);
            validateOrderPriceUnit(orderPrice);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_INVALID_INPUT_FORMAT.getMessage());
        }
    }
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

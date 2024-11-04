package lotto.validator;

import lotto.model.ExceptionMessage;

public class PriceValidator {

    public static void validatePrice(int price) {
        if (price == 0 || price % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PRICE.getMessage());
        }
    }
}

package lotto.view.validation;

import static lotto.service.exception.LottoExceptionMessage.PRICE_NOT_POSITIVE_INTEGER;
import static lotto.service.exception.LottoExceptionMessage.PRICE_OVERFLOW;

import lotto.service.exception.LottoException;

public class PriceValidator {

    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    public static int validate(String price) {
        validatePositiveInteger(price);
        validateOverflow(price);
        return Integer.parseInt(price);
    }

    private static void validatePositiveInteger(String price) {
        if (!price.matches(POSITIVE_INTEGER_REGEX)) {
            throw new LottoException(PRICE_NOT_POSITIVE_INTEGER);
        }
    }

    private static void validateOverflow(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new LottoException(PRICE_OVERFLOW);
        }
    }
}

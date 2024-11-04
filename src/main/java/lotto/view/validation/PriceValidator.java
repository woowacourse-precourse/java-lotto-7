package lotto.view.validation;

import static lotto.service.exception.LottoExceptionMessage.PRICE_NOT_POSITIVE_INTEGER;
import static lotto.service.exception.LottoExceptionMessage.PRICE_NOT_THOUSANDS_UNIT;
import static lotto.service.exception.LottoExceptionMessage.PRICE_OVERFLOW;

import lotto.service.exception.LottoException;

public class PriceValidator {

    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
    private static final int PRICE_UNIT = 1_000;

    public static int validate(String price) {
        validatePositiveInteger(price);
        validateOverflow(price);
        validateThousandsUnit(price);
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

    private static void validateThousandsUnit(String price) {
        if (Integer.parseInt(price) % PRICE_UNIT != 0) {
            throw new LottoException(PRICE_NOT_THOUSANDS_UNIT);
        }
    }
}

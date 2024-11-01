package lotto.validator;

import static lotto.CompareInteger.PRICE_LOTTO;
import static lotto.CompareInteger.ZERO;
import static lotto.PriceRule.MATCH_NUMBER;
import static lotto.PriceRule.PRICE_UNIT;

public class PriceValidator {

    public static void validatePriceUnit(int price) throws IllegalArgumentException {
        if (price % PRICE_LOTTO.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(PRICE_UNIT.getMessage());
        }
    }


}

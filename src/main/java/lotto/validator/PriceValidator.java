package lotto.validator;


import static lotto.constant.CompareInteger.*;
import static lotto.constant.CompareInteger.PRICE_MAXIMUM;
import static lotto.constant.PriceRule.PRICE_UNIT;
import static lotto.constant.PriceRule.SCOPE;

public class PriceValidator {

    public static void validatePrice(int price) {
        NumberValidator.validateScope(PRICE_MINIMUM.getNumber(), PRICE_MAXIMUM.getNumber(), price, SCOPE.getMessage());
        PriceValidator.validatePriceUnit(price);
    }

    private static void validatePriceUnit(int price) throws IllegalArgumentException {
        if (price % PRICE_LOTTO.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(PRICE_UNIT.getMessage());
        }
    }
}

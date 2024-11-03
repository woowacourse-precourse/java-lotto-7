package lotto.service;

import static lotto.common.Constants.*;
import static lotto.common.ValidationUtils.*;

public class Validator {
    public static void validatePurchaseAmount (String rawPurchaseAmount) {
        validateNumber(rawPurchaseAmount, INVALID_PRICE_UNIT);
        validateUnderMax(rawPurchaseAmount, MAX_PURCHASE_AMOUNT, UP_MAX_PURCHASE_AMOUNT);

        Integer purchaseAmount = Integer.parseInt(rawPurchaseAmount);
        validateAmountUnit(purchaseAmount, LOTTO_PRICE_UNIT, INVALID_PRICE_UNIT);

    }
}

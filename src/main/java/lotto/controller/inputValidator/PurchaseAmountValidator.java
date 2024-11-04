package lotto.controller.inputValidator;

import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_BLANK;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_NON_NUMERIC;
import static lotto.util.CommonValidator.parseLong;
import static lotto.util.CommonValidator.validateNotBlank;

public class PurchaseAmountValidator {
    public static Long validate(String purchaseAmount) {
        validateNotBlank(purchaseAmount, PURCHASE_AMOUNT_BLANK.getMessage());
        return parseLong(purchaseAmount, PURCHASE_AMOUNT_NON_NUMERIC.getMessage());
    }
}

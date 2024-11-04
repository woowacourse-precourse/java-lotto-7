package lotto.controller.inputValidator;

import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_BLANK;
import static lotto.exception.ErrorBase.PURCHASE_AMOUNT_NON_NUMERIC;
import static lotto.util.CommonValidator.parseLong;
import static lotto.util.CommonValidator.validateMultipleOf;
import static lotto.util.CommonValidator.validateNotBlank;
import static lotto.util.CommonValidator.validatePositiveAmount;
import static lotto.util.LottoConstants.LOTTO_PURCHASE_AMOUNT;

public class PurchaseAmountValidator {
    public static Long validate(String purchaseAmount) {
        validateNotBlank(purchaseAmount, PURCHASE_AMOUNT_BLANK.getMessage());
        Long parsedPurchaseAmount = parseLong(purchaseAmount, PURCHASE_AMOUNT_NON_NUMERIC.getMessage());
        validatePositiveAmount(parsedPurchaseAmount);
        validateMultipleOf(parsedPurchaseAmount, LOTTO_PURCHASE_AMOUNT);
        return parsedPurchaseAmount;
    }
}

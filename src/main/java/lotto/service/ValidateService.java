package lotto.service;

import lotto.util.Constant;
import lotto.util.ErrorCode;

public class ValidateService {

    public int validatePurchaseAmount(String purchaseAmount) {
        if (!purchaseAmount.matches(Constant.PURCHASE_AMOUNT_CHECK_REGEX)) {
            throw ErrorCode.INVALD_PURCHASE_AMOUNT.exception();
        }

        int purchaseValue = Integer.parseInt(purchaseAmount);

        if (purchaseValue < 1000 || purchaseValue > 100_000) {
            throw ErrorCode.INVALD_PURCHASE_AMOUNT.exception();
        }

        if (purchaseValue % 1000 != 0) {
            throw ErrorCode.INVALD_PURCHASE_AMOUNT.exception();
        }

        return purchaseValue;
    }

}

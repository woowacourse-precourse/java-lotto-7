package lotto.validator;

import lotto.constants.Constants;

public class PurchaseAmountValidator {

    public boolean isValidPurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % Constants.PURCHASE_UNIT == 0;
    }
}

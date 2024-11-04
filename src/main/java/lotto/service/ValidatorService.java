package lotto.service;

import lotto.constants.ConstraintConstants;

public class ValidatorService {
    public static boolean validatePurchaseAmount(int purchaseAmount) {
        return purchaseAmount % ConstraintConstants.PURCHASE_UNIT == 0
                && purchaseAmount <= ConstraintConstants.MAX_PURCHASE_AMOUNT;
    }


}

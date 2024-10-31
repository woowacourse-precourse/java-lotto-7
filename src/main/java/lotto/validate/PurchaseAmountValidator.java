package lotto.validate;

import static lotto.constants.LottoConstants.PURCHASE_UNIT_WON;

import lotto.constants.ErrorMessage;

public class PurchaseAmountValidator {

    public static void validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        validateInputType(purchaseAmount);
        validateInputUnit(Integer.parseInt(purchaseAmount));
    }

    private static void validateInputUnit(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount % PURCHASE_UNIT_WON != 0 || purchaseAmount < PURCHASE_UNIT_WON) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_UNIT.getMessage());
        }
    }

    private static void validateInputType(String purchaseAmount) throws IllegalArgumentException {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_TYPE.getMessage());
        }
    }
}

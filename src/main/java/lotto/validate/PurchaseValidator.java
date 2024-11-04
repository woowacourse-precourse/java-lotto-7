package lotto.validate;

import static lotto.constants.LottoConstants.PURCHASE_UNIT_WON;

import lotto.constants.ErrorMessage;

public class PurchaseValidator extends Validator{

    public static void validatePurchaseAmount(String purchaseAmount) throws IllegalArgumentException {
        isEmpty(purchaseAmount);
        validateUnit(parseToInt(purchaseAmount));
    }

    private static void validateUnit(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount % PURCHASE_UNIT_WON != 0 || purchaseAmount < PURCHASE_UNIT_WON) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_UNIT.getMessage());
        }
    }
}

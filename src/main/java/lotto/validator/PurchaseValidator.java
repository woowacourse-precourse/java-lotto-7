package lotto.validator;

import lotto.constant.ErrorMessages;
import lotto.constant.LottoConstants;
import lotto.exception.InputException;

public class PurchaseValidator {

    public static int validatePurchaseAmount(String purchaseAmount) {
        int purchaseAmountInt = parsePurchaseAmount(purchaseAmount);
        checkPurchaseAmountIsMultipleOfUnit(purchaseAmountInt);
        return purchaseAmountInt;
    }

    private static int parsePurchaseAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new InputException(ErrorMessages.ERROR_NON_INTEGER_AMOUNT);
        }
    }

    private static void checkPurchaseAmountIsMultipleOfUnit(int purchaseAmountInt) {
        if (purchaseAmountInt <= 0 || purchaseAmountInt % LottoConstants.LOTTO_PRICE_UNIT != 0) {
            throw new InputException(ErrorMessages.ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT);
        }
    }
}

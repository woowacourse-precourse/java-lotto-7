package lotto.validation;

import static lotto.constants.ErrorMessage.PURCHASE_MONEY_ONLY_CAN_NUMBER;
import static lotto.constants.ErrorMessage.PURCHASE_MONEY_ONLY_CAN_THOUSAND_UNIT;
import static lotto.constants.Purchase.LOTTO_PRICE_PER_UNIT;

public class PurchaseValidation {

    public static int validateNumericAmount(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_MONEY_ONLY_CAN_NUMBER.getErrorMessage());
        }
    }

    public static void validateDivisibleThousand(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE_PER_UNIT > 0) {
            throw new IllegalArgumentException(PURCHASE_MONEY_ONLY_CAN_THOUSAND_UNIT.getErrorMessage());
        }
    }
}

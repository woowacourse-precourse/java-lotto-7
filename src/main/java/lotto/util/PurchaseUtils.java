package lotto.util;

import static lotto.constants.Purchase.LOTTO_PRICE_PER_UNIT;
import static lotto.validation.PurchaseValidation.validateDivisibleThousand;
import static lotto.validation.PurchaseValidation.validateNumericAmount;

public class PurchaseUtils {
    public static int getThousandUnitCount(String inputPurchaseAmount) {
        int purchaseAmount = validateNumericAmount(inputPurchaseAmount);
        validateDivisibleThousand(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE_PER_UNIT;
    }
}

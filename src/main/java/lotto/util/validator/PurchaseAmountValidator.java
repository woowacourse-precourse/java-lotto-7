package lotto.util.validator;

import static lotto.util.Constants.ERROR_PREFIX;
import static lotto.util.Constants.LOTTO_PRICE;

public class PurchaseAmountValidator {
    private static final String AMOUNT_RANGE_ERROR_MESSAGE = ERROR_PREFIX + "구입 금액은 0보다 커야하고 1억 미만이어야 합니다.";
    private static final String AMOUNT_UNITS_ERROR_MESSAGE = ERROR_PREFIX + "구입 금액은 1000원 단위로 입력해야 합니다.";
    private static final int PURCHASE_MAX_AMOUNT = 100000000;

    public static int validate(String purchaseAmount) {
        NumericValidator.validate(purchaseAmount);
        int amount = Integer.parseInt(purchaseAmount);
        validateRange(amount);
        validateAmountInUnitsOfThousand(amount);
        return amount;
    }

    private static void validateRange(int amount) {
        if (amount <= 0 || amount >= PURCHASE_MAX_AMOUNT) {
            throw new IllegalArgumentException(AMOUNT_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateAmountInUnitsOfThousand(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_UNITS_ERROR_MESSAGE);
        }
    }
}

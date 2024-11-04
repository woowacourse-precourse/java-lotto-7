package lotto.model;

import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_BELOW_MINIMUM;
import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_MUST_BE_NUMBER;
import static lotto.enums.ErrorCode.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    public Lottos purchaseLottos(String purchaseAmountInput) {
        validatePurchaseAmount(purchaseAmountInput);

        long purchaseAmount = parsePurchaseAmount(purchaseAmountInput);
    }

    private void validatePurchaseAmount(String purchaseAmountInput) {
        checkIsNumber(purchaseAmountInput);
        long purchaseAmount = parsePurchaseAmount(purchaseAmountInput);
        checkMinimumAmount(purchaseAmount);
        checkUnit(purchaseAmount);
    }

    private long parsePurchaseAmount(String purchaseAmountInput) {
        return Long.parseLong(purchaseAmountInput);
    }

    private static void checkIsNumber(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_BE_NUMBER.getMessage());
        }
    }

    private static void checkMinimumAmount(long purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_BELOW_MINIMUM.getMessage());
        }
    }

    private static void checkUnit(long purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_1000.getMessage());
        }
    }
}

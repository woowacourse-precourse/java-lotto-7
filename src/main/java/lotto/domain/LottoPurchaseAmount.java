package lotto.domain;

import static lotto.common.constants.exception.ErrorMessage.*;

public class LottoPurchaseAmount {

    private static final String LOTTO_PURCHASE_AMOUNT_REGEX = "^[1-9]\\d*$";

    private final int purchaseAmount;

    private LottoPurchaseAmount(String purchaseAmount) {
        Validator.validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    public static LottoPurchaseAmount from(String purchaseAmount) {
        return new LottoPurchaseAmount(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private static class Validator {

        private static final int PURCHASE_AMOUNT_UNIT = 1000;
        private static final int REMAINDER = 0;

        private static void validatePurchaseAmount(String purchaseAmount) {
            validatePurchaseAmountIsNotEmpty(purchaseAmount);
            validatePurchaseAmountRegex(purchaseAmount);
            validatePurchaseAmountUnit(purchaseAmount);
        }

        private static void validatePurchaseAmountIsNotEmpty(String purchaseAmount) {
            if (purchaseAmount == null || purchaseAmount.isBlank()) {
                throw new IllegalArgumentException(EMPTY_PURCHASE_AMOUNT.getMessage());
            }
        }

        private static void validatePurchaseAmountRegex(String purchaseAmount) {
            if (!purchaseAmount.matches(LOTTO_PURCHASE_AMOUNT_REGEX)) {
                throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
            }
        }

        private static void validatePurchaseAmountUnit(String purchaseAmount) {
            if (Integer.parseInt(purchaseAmount) % PURCHASE_AMOUNT_UNIT != REMAINDER) {
                throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
            }
        }

    }

}
package lotto.domain;

import lotto.ExceptionMessages;

public class PurchaseAmount {
    private final int purchaseAmount;
    private static PurchaseAmount purchaseAmountInstance;

    private PurchaseAmount(int purchaseInput) {
        new ValidatorPurchaseAmount(purchaseInput);
        purchaseAmount = purchaseInput;
    }

    public static PurchaseAmount getPurchaseAmount() {
        if (purchaseAmountInstance == null) throw new IllegalArgumentException
                (ExceptionMessages.SINGLETON_NOT_CREATED_EXCEPTION_MESSAGE.getMessage());
        return purchaseAmountInstance;
    }

    public static PurchaseAmount getPurchaseAmount(int purchaseInput) {
        if (purchaseAmountInstance == null) purchaseAmountInstance = new PurchaseAmount(purchaseInput);
        return purchaseAmountInstance;
    }

    public static void resetInstance() {
        if ("true".equals(System.getProperty("IS_TEST_ENV"))) {
            purchaseAmountInstance = null;
        }
    }


    public int getPurchaseAmountValue() {
        return purchaseAmount;
    }

    public int getPurchaseCount() {
        return purchaseAmount / 1000;
    }


    private static class ValidatorPurchaseAmount {
        private static final int MIN_PURCHASE_AMOUNT = 1_000;
        private static final int MAX_PURCHASE_AMOUNT = 100_000;

        public ValidatorPurchaseAmount(int purchaseAmount) {
            checkBoundaryPurchaseAmount(purchaseAmount);
            checkMultipleOfThousand(purchaseAmount);
        }

        private static void checkBoundaryPurchaseAmount(int purchaseAmount) {
            if (purchaseAmount < MIN_PURCHASE_AMOUNT)
                throw new IllegalArgumentException
                        (ExceptionMessages.PURCHASE_BOUNDARY_OVER_EXCEPTION_MESSAGE.getMessage());
            if (purchaseAmount > MAX_PURCHASE_AMOUNT)
                throw new IllegalArgumentException
                        (ExceptionMessages.PURCHASE_BOUNDARY_OVER_EXCEPTION_MESSAGE.getMessage());
        }

        private static void checkMultipleOfThousand(int purchaseAmount) {
            if (purchaseAmount % 1000 != 0)
                throw new IllegalArgumentException
                        (ExceptionMessages.PURCHASE_MULTIPLE_THOUSAND_EXCEPTION_MESSAGE.getMessage());
        }
    }
}

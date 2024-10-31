package lotto.domain;

public class PurchaseAmount {
    private final int purchaseAmount;
    private static PurchaseAmount purchaseAmountInstance;

    private PurchaseAmount(int purchaseInput) {
        new ValidatorPurchaseAmount(purchaseInput);
        purchaseAmount = purchaseInput;
    }

    public static PurchaseAmount getPurchaseAmount(int purchaseInput) {
        if (purchaseAmountInstance == null) purchaseAmountInstance = new PurchaseAmount(purchaseInput);
        return purchaseAmountInstance;
    }


    public int getPurchaseAmount() {
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
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1_000이상 100_000 이하의 값만 가능합니다.");
            if (purchaseAmount > MAX_PURCHASE_AMOUNT)
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1_000이상 100_000 이하의 값만 가능합니다.");
        }

        private static void checkMultipleOfThousand(int purchaseAmount) {
            if (purchaseAmount % 1000 != 0)
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로만 가능합니다.");
        }
    }
}

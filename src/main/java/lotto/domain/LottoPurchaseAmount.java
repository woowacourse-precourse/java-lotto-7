package lotto.domain;

public class LottoPurchaseAmount {

    private static final String LOTTO_PURCHASE_AMOUNT_REGEX = "^[1-9]\\d*$";

    private final int purchaseAmount;

    private LottoPurchaseAmount(String purchaseAmount) {
        Validator.validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    public static LottoPurchaseAmount from(String amount) {
        return new LottoPurchaseAmount(amount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private static class Validator {

        private static void validatePurchaseAmount(String purchaseAmount) {
            validatePurchaseAmountRegex(purchaseAmount);
            validatePurchaseAmountUnit(purchaseAmount);
        }

        private static void validatePurchaseAmountRegex(String purchaseAmount) {
            if (!purchaseAmount.matches(LOTTO_PURCHASE_AMOUNT_REGEX)) {
                throw new IllegalArgumentException("구입 금액은 양수만 입력 가능합니다.");
            }
        }

        private static void validatePurchaseAmountUnit(String purchaseAmount) {
            if (Integer.parseInt(purchaseAmount) % 1000 != 0) {
                throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력할 수 있습니다.");
            }
        }

    }

}
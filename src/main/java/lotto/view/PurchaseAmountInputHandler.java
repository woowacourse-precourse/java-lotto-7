package lotto.view;

public class PurchaseAmountInputHandler {

    public static void validatePurchaseAmount(String input) {
        int purchaseAmount = validatePurchaseAmountIsInteger(input);
        validatePurchaseAmountIsThousandUnit(purchaseAmount);
    }

    public static int validatePurchaseAmountIsInteger(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
    }

    public static void validatePurchaseAmountIsThousandUnit(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}

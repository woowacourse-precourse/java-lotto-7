package lotto.util.validator;

public class PurchaseAmountValidator {

    public static void validatePurchaseAmount(String input) {
        int amount = parsePurchaseAmount(input);
        validateDivisibility(amount);
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
    }

    private static void validateDivisibility(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}

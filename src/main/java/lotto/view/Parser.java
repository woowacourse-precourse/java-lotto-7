package lotto.view;

public class Parser {

    private final static String ERROR_NOT_DIVISIBLE_BY_1000_MESSAGE = "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";

    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_1000_MESSAGE);
        }
    }
}

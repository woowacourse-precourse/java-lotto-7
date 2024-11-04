package lotto.domain;

public class Validator {
    public static final String INVALID_PURCHASE_AMOUNT_TYPE_ERROR = "[ERROR] 구입 금액은 숫자로 입력해야 합니다.";

    public static void validatePurchaseAmount(String input) {
        int purchaseAmount = parsePurchaseAmount(input);
    }

    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_TYPE_ERROR);
        }
    }
}

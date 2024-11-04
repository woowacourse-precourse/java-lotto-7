package lotto;

public record PurchaseAmount(int amount) {
    private static final String SIGNED_NUMBER_REGEX = "-?[0-9]+";

    public PurchaseAmount(String input) {
        this(validatePurchaseAmount(input));
    }

    private static int validatePurchaseAmount(String input) {
        validateLetter(input);
        int purchaseAmount = parseInt(input);
        validatePositive(purchaseAmount);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return purchaseAmount;
    }

    private static void validateLetter(String value) {
        if (isLetter(value)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 문자가 아닌 숫자여야 합니다.");
        }
    }

    private static void validatePositive(int purchaseAmount) {
        if (!isPositive(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수인 숫자여야 합니다.");
        }
    }

    private static boolean isLetter(String value) {
        return !value.matches(SIGNED_NUMBER_REGEX);
    }

    private static boolean isPositive(int purchaseAmount) {
        return purchaseAmount > 0;
    }

    private static int parseInt(String amount) {
        return Integer.parseInt(amount);
    }
}
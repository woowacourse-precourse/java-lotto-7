package lotto;

public record PurchaseAmount(int amount) {
    private static final String SIGNED_NUMBER_REGEX = "-?[0-9]+";

    public PurchaseAmount(String input) {
        this(validatePurchaseAmount(input));
    }

    private static int validatePurchaseAmount(String input) {
        validateLetter(input);
        return Integer.parseInt(input);
    }

    private static void validateLetter(String value) {
        if (isLetter(value)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 문자가 아닌 숫자여야 합니다.");
        }
    }

    private static boolean isLetter(String value) {
        return !value.matches(SIGNED_NUMBER_REGEX);
    }
}
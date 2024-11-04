package lotto;

public record PurchaseAmount(int amount) {
    private static final String SIGNED_NUMBER_REGEX = "-?[0-9]+";

    public PurchaseAmount(String input) {
        this(validatePurchaseAmount(input));
    }

    private static int validatePurchaseAmount(String input) {
        if (!input.matches(SIGNED_NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 문자가 아닌 숫자여야 합니다.");
        }
        return Integer.parseInt(input);
    }
}
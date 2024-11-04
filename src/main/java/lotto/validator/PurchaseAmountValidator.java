package lotto.validator;

public class PurchaseAmountValidator {
    private static final int LOTTO_PRICE = 1_000;
    private static final String ERROR_POSITIVE = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    private static final String ERROR_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    private PurchaseAmountValidator() {
    }

    public static void validate(int amount) {
        validatePositive(amount);
        validateUnit(amount);
    }

    private static void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ERROR_POSITIVE);
        }
    }

    private static void validateUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_UNIT);
        }
    }
}
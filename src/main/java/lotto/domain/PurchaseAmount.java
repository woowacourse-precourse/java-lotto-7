package lotto.domain;

public class PurchaseAmount {
    private static final String ERROR_NOT_NATURAL_NUMBER = "[ERROR] 구입금액은 자연수여야 합니다.";
    private static final String ERROR_DIFFERENT_UNIT = "[ERROR] 구입금액은 1000 단위여야 합니다.";

    private final int value;

    private PurchaseAmount(int value) {
        this.value = value;
    }

    public static PurchaseAmount from(String input) {
        validateNaturalNumber(input);
        int value = Integer.parseInt(input);
        validateUnit(value);
        return new PurchaseAmount(value);
    }

    private static void validateNaturalNumber(String input) {
        if (input == null || input.isEmpty() || !input.matches("[0-9]*")) {
            throw new IllegalArgumentException(ERROR_NOT_NATURAL_NUMBER);
        }
    }

    private static void validateUnit(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_DIFFERENT_UNIT);
        }
    }
}

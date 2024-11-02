package lotto.domain;

public class PurchaseAmount {
    private static final int UNIT = 1000; // 이것도 분리할 수 있지 않을까
    // 에러 코드를 하나로 묶는 건?
    private static final String ERROR_NOT_NATURAL_NUMBER = "[ERROR] 구입금액은 자연수여야 합니다.\n";
    private static final String ERROR_DIFFERENT_UNIT = String.format("[ERROR] 구입금액은 %d 단위여야 합니다.\n", UNIT);

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

    public int getCountPerUnit() {
        return value / UNIT;
    }
}

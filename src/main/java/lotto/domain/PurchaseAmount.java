package lotto.domain;

public class PurchaseAmount {
    private static final int UNIT = 1000;
    private static final int RANGE = 0;
    private static final String ERROR_OUT_OF_RANGE = String.format("[ERROR] 구입금액은 %d 이상이여야 합니다.", RANGE);
    private static final String ERROR_DIFFERENT_UNIT = String.format("[ERROR] 구입금액은 %d 단위여야 합니다.", UNIT);

    private final int value;

    public PurchaseAmount(int value) {
        validateNaturalNumber(value);
        validateUnit(value);
        this.value = value;
    }

    private void validateNaturalNumber(int value) {
        if (value < RANGE) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    private void validateUnit(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_DIFFERENT_UNIT);
        }
    }

    public int getCountPerUnit() {
        return value / UNIT;
    }

    public int getValue() {
        return value;
    }
}

package lotto.enums;

public enum LottoNumberConstants {
    MAX_VALUE(45),
    MIN_VALUE(1),
    NUMBER_COUNT(6);

    private final int value;

    LottoNumberConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

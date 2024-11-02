package lotto.util;

public enum GeneratorConstants {

    LOTTO_NUMBER_COUNT(6),
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45);

    private final int value;

    GeneratorConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

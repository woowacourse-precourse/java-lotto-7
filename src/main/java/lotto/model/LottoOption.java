package lotto.model;

public enum LottoOption {
    MIN_NUMBER_OF_RANGE(1),
    MAX_NUMBER_OF_RANGE(45),
    TOTAL_ELEMENT_COUNT(6);

    private final int value;

    LottoOption(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

}

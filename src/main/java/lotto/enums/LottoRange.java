package lotto.enums;

public enum LottoRange {
    MIN(1),
    MAX(45),
    NUMBER_COUNT(6);
    private final int range;

    LottoRange(int range) {
        this.range = range;
    }

    public int getValue() {
        return range;
    }
}
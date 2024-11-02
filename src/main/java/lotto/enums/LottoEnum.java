package lotto.enums;

public enum LottoEnum {
    MIN_LOTTO_RANGE(1),
    MAX_LOTTO_RANGE(45);

    int range;

    LottoEnum(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}

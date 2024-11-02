package lotto.global.contents;

public enum LottoDetail {

    PRICE(1000),
    MIN_VALUE(1),
    MAX_VALUE(45),
    NUMBER_COUNT(6);

    private final int value;

    LottoDetail(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

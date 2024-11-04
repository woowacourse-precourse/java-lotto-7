package lotto.value;

public enum LottoValue {
    START_NUMBER_INCLUSIVE(1),
    END_NUMBER_INCLUSIVE(45),
    NUMBER_COUNT(6),
    PRICE(1000),
    ;

    private final int value;

    LottoValue(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}

package lotto.enums;

public enum LottoConstant {
    PRICE(1000),
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6),

    ;

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package lotto.constant;

public enum LottoConstant {
    LOTTO_MIN_NUM(1),
    LOTTO_MAX_NUM(45),
    LOTTO_SIZE(6),
    PRICE(1000);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
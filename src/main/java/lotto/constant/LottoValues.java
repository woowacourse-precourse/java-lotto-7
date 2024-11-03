package lotto.constant;

public enum LottoValues {
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_SIZE(6),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    LottoValues(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }
}

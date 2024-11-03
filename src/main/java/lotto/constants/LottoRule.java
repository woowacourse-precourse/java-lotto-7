package lotto.constants;

public enum LottoRule {
    LOTTO_NUMBER_SIX(6),
    SAME_NUMBER_COUNT(1),
    Lotto_Number_Min(1),
    Lotto_Number_Max(45),
    USE_ZERO(0),
    Thousand_Multi_Number(1000);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

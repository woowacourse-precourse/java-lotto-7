package lotto.constants;

public enum LottoConstants {
    LOWER_BOUND(1)
    ,UPPER_BOUND(45)
    ,NUMBERS_PER_LOTTO(6)
    ,LOTTO_PRICE (1000)
    ,PURCHASE_LIMIT(100000)
    ,;

    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

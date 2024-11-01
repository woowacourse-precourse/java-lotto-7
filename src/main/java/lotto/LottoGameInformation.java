package lotto;

public enum LottoGameInformation {
    PURCHASE_PRICE(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    // If you change the Lotto size, you also need to modify LottoRank
    LOTTO_SIZE(6);

    private final int value;

    LottoGameInformation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

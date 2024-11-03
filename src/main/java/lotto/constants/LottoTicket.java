package lotto.constants;

public enum LottoTicket {
    LOWER_BOUND(1)
    ,UPPER_BOUND(45)
    ,NUMBERS_PER_LOTTO(6)
    ,LOTTO_PRICE (1000)
    ,PURCHASE_LIMIT(100000)
    ,;

    private final int value;

    LottoTicket(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

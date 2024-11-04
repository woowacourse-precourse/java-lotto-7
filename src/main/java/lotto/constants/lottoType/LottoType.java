package lotto.constants.lottoType;

public enum LottoType {

    LOTTO_PRICE(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_INIT_RANK(0),
    RANK_INCREMENT_VALUE(1),
    ZERO_MONEY(0),
    ZERO_TICKET(0);

    private final int value;

    LottoType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

package lotto.constants.lottoType;

public enum LottoType {

    LOTTO_PRICE(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_INIT_RANK(0),
    LOTTO_RANK_UPDATE_VALUE(1);

    private final int value;

    LottoType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}

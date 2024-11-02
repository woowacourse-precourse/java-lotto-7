package lotto.enums;

public enum LottoConstant {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    PRICE(1000),
    LOTTO_RANK_COUNT(5);

    private final int number;

    LottoConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

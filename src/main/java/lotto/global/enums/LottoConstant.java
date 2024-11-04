package lotto.global.enums;

public enum LottoConstant {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private final Integer number;

    LottoConstant(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}

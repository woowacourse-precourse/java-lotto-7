package lotto.lotto;

enum LottoConstant {

    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_SIZE(6),
    ;

    private int value;

    LottoConstant(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}

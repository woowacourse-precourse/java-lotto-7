package lotto.domain.rule;

public enum LottoRules {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_COUNT(6),
    AUTO_LOTTO_PRICE(1000);



    private final int value;

    LottoRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

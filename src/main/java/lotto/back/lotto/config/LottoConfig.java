package lotto.back.lotto.config;

public enum LottoConfig {

    PRICE(1000),
    SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);


    private final Integer value;


    LottoConfig(Integer value) {
        this.value = value;
    }


    public Integer get() {
        return value;
    }
}

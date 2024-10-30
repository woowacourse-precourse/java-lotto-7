package lotto.constants;

public enum LottoConstants {

    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    ;

    private final Integer value;

    LottoConstants(final Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

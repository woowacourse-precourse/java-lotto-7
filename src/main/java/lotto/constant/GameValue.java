package lotto.constant;

public enum GameValue {
    NUMBER_SIZE(6),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45);

    private final Integer value;

    GameValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

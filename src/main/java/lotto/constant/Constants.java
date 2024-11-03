package lotto.constant;

public enum Constants {
    DIVISOR(1000),
    Zero(0),
    LOTTO_SIZE(6),
    LOTTO_NUMBER_START_RANGE(1),
    LOTTO_NUMBER_END_RANGE(45),
    PERCENT(100);

    private final Integer constant;

    Constants(Integer constant) {this.constant = constant;}

    public Integer getConstant() {
        return constant;
    }
}

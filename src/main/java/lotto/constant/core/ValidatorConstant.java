package lotto.constant.core;

public enum ValidatorConstant implements BaseConstant {

    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000)
    ;

    private final Object constant;

    ValidatorConstant(Object constant) {
        this.constant = constant;
    }

    @Override
    public String getStringValue() {
        return (String) constant;
    }

    @Override
    public Integer getIntegerValue() {
        return (Integer) constant;
    }
}

package lotto.constant.core;

public enum LottoServiceConstant implements BaseConstant {

    LOTTO_PRICE(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    EARNING_RATE_DECIMAL_PLACE(1)
    ;

    private final Object constant;

    LottoServiceConstant(Object constant) {
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

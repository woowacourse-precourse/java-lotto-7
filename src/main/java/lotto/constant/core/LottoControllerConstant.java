package lotto.constant.core;

public enum LottoControllerConstant implements BaseConstant {

    LOTTO_TICKETS_JOINER(", ")
    ;

    private final Object constant;

    LottoControllerConstant(Object constant) {
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

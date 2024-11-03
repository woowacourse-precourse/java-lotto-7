package lotto.constant.core;

public enum ParserConstant implements BaseConstant {

    PLURAL_INPUT_SEPARATOR(",")
    ;

    private final Object constant;

    ParserConstant(Object constant) {
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

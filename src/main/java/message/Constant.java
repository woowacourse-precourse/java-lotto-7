package message;

public enum Constant {

    LOTTO_AMOUNT(1_000),
    NUMBER_OF_NUMBERS(6),
    START_OF_NUMBERS(1),
    END_OF_NUMBERS(45);

    private final Integer constant;

    Constant(Integer constant) {
        this.constant = constant;
    }

    public Integer getConstant() {
        return constant;
    }
}
